package dev.egorand.adventofcode

import dev.egorand.adventofcode.Instruction.Acc
import dev.egorand.adventofcode.Instruction.Jmp
import dev.egorand.adventofcode.Instruction.Nop
import dev.egorand.adventofcode.ProgramRunner.Result.InfiniteLoop
import dev.egorand.adventofcode.ProgramRunner.Result.Terminated

/**
 * --- Day 8: Handheld Halting ---
 *
 * Your flight to the major airline hub reaches cruising altitude without incident. While you
 * consider checking the in-flight menu for one of those drinks that come with a little umbrella,
 * you are interrupted by the kid sitting next to you.
 *
 * Their handheld game console won't turn on! They ask if you can take a look.
 *
 * You narrow the problem down to a strange infinite loop in the boot code (your puzzle input) of
 * the device. You should be able to fix it, but first you need to be able to run the code in
 * isolation.
 *
 * The boot code is represented as a text file with one instruction per line of text. Each
 * instruction consists of an operation (acc, jmp, or nop) and an argument (a signed number like
 * +4 or -20).
 *
 * - acc increases or decreases a single global value called the accumulator by the value given in
 *   the argument. For example, acc +7 would increase the accumulator by 7. The accumulator starts
 *   at 0. After an acc instruction, the instruction immediately below it is executed next.
 * - jmp jumps to a new instruction relative to itself. The next instruction to execute is found
 *   using the argument as an offset from the jmp instruction; for example, jmp +2 would skip the
 *   next instruction, jmp +1 would continue to the instruction immediately below it, and jmp -20
 *   would cause the instruction 20 lines above to be executed next.
 * - nop stands for No OPeration - it does nothing. The instruction immediately below it is
 *   executed next.
 *
 * For example, consider the following program:
 *
 * nop +0
 * acc +1
 * jmp +4
 * acc +3
 * jmp -3
 * acc -99
 * acc +1
 * jmp -4
 * acc +6
 *
 * These instructions are visited in this order:
 *
 * nop +0  | 1
 * acc +1  | 2, 8(!)
 * jmp +4  | 3
 * acc +3  | 6
 * jmp -3  | 7
 * acc -99 |
 * acc +1  | 4
 * jmp -4  | 5
 * acc +6  |
 *
 * First, the nop +0 does nothing. Then, the accumulator is increased from 0 to 1 (acc +1) and
 * jmp +4 sets the next instruction to the other acc +1 near the bottom. After it increases the
 * accumulator from 1 to 2, jmp -4 executes, setting the next instruction to the only acc +3. It
 * sets the accumulator to 5, and jmp -3 causes the program to continue back at the first acc +1.
 *
 * This is an infinite loop: with this sequence of jumps, the program will run forever. The moment
 * the program tries to run any instruction a second time, you know it will never terminate.
 *
 * Immediately before the program would run an instruction a second time, the value in the
 * accumulator is 5.
 *
 * Run your copy of the boot code. Immediately before any instruction is executed a second time,
 * what value is in the accumulator?
 *
 * --- Part Two ---
 *
 * After some careful analysis, you believe that exactly one instruction is corrupted.
 *
 * Somewhere in the program, either a jmp is supposed to be a nop, or a nop is supposed to be a
 * jmp. (No acc instructions were harmed in the corruption of this boot code.)
 *
 * The program is supposed to terminate by attempting to execute an instruction immediately after
 * the last instruction in the file. By changing exactly one jmp or nop, you can repair the boot
 * code and make it terminate correctly.
 *
 * For example, consider the same program from above:
 *
 * nop +0
 * acc +1
 * jmp +4
 * acc +3
 * jmp -3
 * acc -99
 * acc +1
 * jmp -4
 * acc +6
 *
 * If you change the first instruction from nop +0 to jmp +0, it would create a single-instruction
 * infinite loop, never leaving that instruction. If you change almost any of the jmp instructions,
 * the program will still eventually find another jmp instruction and loop forever.
 *
 * However, if you change the second-to-last instruction (from jmp -4 to nop -4), the program
 * terminates! The instructions are visited in this order:
 *
 * nop +0  | 1
 * acc +1  | 2
 * jmp +4  | 3
 * acc +3  |
 * jmp -3  |
 * acc -99 |
 * acc +1  | 4
 * nop -4  | 5
 * acc +6  | 6
 *
 * After the last instruction (acc +6), the program terminates by attempting to run the instruction
 * below the last instruction in the file. With this change, after the program terminates, the
 * accumulator contains the value 8 (acc +1, acc +1, acc +6).
 *
 * Fix the program so that it terminates normally by changing exactly one jmp (to nop) or nop (to
 * jmp). What is the value of the accumulator after the program terminates?
 */

object ProgramRunner {
  fun run(program: Program, fixInfiniteLoops: Boolean): Int {
    fun run(program: Program): Result {
      var counter = 0
      var nextIndex = 0
      val visitedInstructionIndices = mutableSetOf<Int>()
      while (true) {
        if (nextIndex in visitedInstructionIndices) {
          return InfiniteLoop(counter)
        } else if (nextIndex >= program.instructions.size) {
          return Terminated(counter)
        }
        visitedInstructionIndices += nextIndex
        when (val nextInstruction = program.instructions[nextIndex]) {
          is Acc -> {
            counter += nextInstruction.arg
            nextIndex += 1
          }
          is Jmp -> {
            nextIndex += nextInstruction.arg
          }
          is Nop -> {
            nextIndex += 1
          }
        }
      }
    }

    // Do a run of the original program to check if it terminates.
    val result = run(program)
    if (result is Terminated || fixInfiniteLoops) {
      return result.output
    }

    program.instructions.forEachIndexed { index, instruction ->
      val fixedInstruction = when (instruction) {
        is Jmp -> Nop(instruction.arg)
        is Nop -> Jmp(instruction.arg)
        is Acc -> instruction
      }
      val fixedProgram = Program(
        program.instructions.toMutableList().apply { set(index, fixedInstruction) }
      )
      val result = run(fixedProgram)
      if (result is Terminated) {
        return result.output
      }
    }
    throw AssertionError("None of the changes fixed the program!")
  }

  private sealed class Result {
    abstract val output: Int

    data class Terminated(override val output: Int) : Result()
    data class InfiniteLoop(override val output: Int) : Result()
  }
}

class Program(val instructions: List<Instruction>) {
  companion object {
    private val INSTRUCTION_REGEX = Regex("(acc|jmp|nop) ([+-])(\\d+)")

    fun compile(source: String): Program {
      val instructions = mutableListOf<Instruction>()
      for (line in source.lines()) {
        val (op, sign, argStr) = line.parse(INSTRUCTION_REGEX)
        val arg = argStr.toInt() * if (sign == "+") 1 else -1
        instructions += when (op) {
          "acc" -> Acc(arg)
          "jmp" -> Jmp(arg)
          "nop" -> Nop(arg)
          else -> throw AssertionError("Unknown op: $op")
        }
      }
      return Program(instructions)
    }
  }
}

sealed class Instruction {
  abstract val arg: Int

  data class Acc(override val arg: Int) : Instruction()
  data class Jmp(override val arg: Int) : Instruction()
  data class Nop(override val arg: Int) : Instruction()
}
