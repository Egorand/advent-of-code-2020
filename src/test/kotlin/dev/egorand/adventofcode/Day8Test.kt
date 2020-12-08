package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day8Test {
  @Test fun `Part 1 - Examples`() {
    val program = Program.compile(
      """
      nop +0
      acc +1
      jmp +4
      acc +3
      jmp -3
      acc -99
      acc +1
      jmp -4
      acc +6
      """.trimIndent()
    )
    assertEquals(5, ProgramRunner.run(program, fixInfiniteLoops = true))
  }

  @Test fun `Part 1 - Input`() {
    val program = Program.compile(readText("inputs/day8"))
    assertEquals(1814, ProgramRunner.run(program, fixInfiniteLoops = true))
  }

  @Test fun `Part 2 - Examples`() {
    val program = Program.compile(
      """
      nop +0
      acc +1
      jmp +4
      acc +3
      jmp -3
      acc -99
      acc +1
      jmp -4
      acc +6
      """.trimIndent()
    )
    assertEquals(8, ProgramRunner.run(program, fixInfiniteLoops = false))
  }

  @Test fun `Part 2 - Input`() {
    val program = Program.compile(readText("inputs/day8"))
    assertEquals(1056, ProgramRunner.run(program, fixInfiniteLoops = false))
  }
}
