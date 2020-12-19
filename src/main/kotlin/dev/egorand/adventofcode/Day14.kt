package dev.egorand.adventofcode

import java.math.BigInteger
import kotlin.math.pow

private val MASK_REGEX = Regex("mask = (\\w+)")
private val WRITE_REGEX = Regex("mem\\[(\\d+)] = (\\d+)")

fun DecoderChip.sumAllValuesInMemory(): BigInteger {
  return memory.values.fold(BigInteger.ZERO, BigInteger::add)
}

abstract class DecoderChip {
  protected val _memory = mutableMapOf<BigInteger, BigInteger>()
  val memory: Map<BigInteger, BigInteger> get() = _memory.toMap()

  fun initializeProgram(instructions: List<String>) {
    var mask = ""
    for (instruction in instructions) {
      if (instruction.startsWith("ma")) {
        mask = instruction.parse(MASK_REGEX).component1()
      } else if (instruction.startsWith("me")) {
        val (address, value) = instruction.parse(WRITE_REGEX)
        executeWriteInstruction(BigInteger(address), BigInteger(value), mask)
      }
    }
  }

  protected abstract fun executeWriteInstruction(
    address: BigInteger,
    value: BigInteger,
    mask: String,
  )

  protected fun BigInteger.mask(mask: String): String {
    val binary = toString(2)
    val result = CharArray(mask.length)
    var i = mask.length - 1
    var j = binary.length - 1
    while (i >= 0) {
      result[i] = maskBit(if (j >= 0) binary[j] else '0', mask[i])
      i -= 1
      j -= 1
    }
    return String(result)
  }

  protected abstract fun maskBit(value: Char, mask: Char): Char
}

class DecoderChipV1 : DecoderChip() {
  override fun executeWriteInstruction(address: BigInteger, value: BigInteger, mask: String) {
    _memory[address] = BigInteger(value.mask(mask), 2)
  }

  override fun maskBit(value: Char, mask: Char): Char = if (mask != 'X') mask else value
}

@ExperimentalStdlibApi
class DecoderChipV2 : DecoderChip() {
  override fun executeWriteInstruction(address: BigInteger, value: BigInteger, mask: String) {
    for (combination in addressCombinations(address, mask)) {
      _memory[combination] = value
    }
  }

  private fun addressCombinations(address: BigInteger, mask: String): List<BigInteger> {
    val maskedAddress = address.mask(mask)
    val actualAddresses = mutableListOf<BigInteger>()
    val indicesOfFloatingBits = indicesOfFloatingBits(maskedAddress)
    for (combination in 0 until 2f.pow(indicesOfFloatingBits.size).toInt()) {
      val actualAddress = maskedAddress.toCharArray()
      var n = combination
      for (i in indicesOfFloatingBits.indices) {
        actualAddress[indicesOfFloatingBits[i]] = if (n % 2 == 0) '0' else '1'
        n /= 2
      }
      actualAddresses += BigInteger(String((actualAddress)), 2)
    }
    return actualAddresses
  }

  private fun indicesOfFloatingBits(maskedAddress: String): List<Int> {
    return buildList {
      maskedAddress.forEachIndexed { index, bit ->
        if (bit == 'X') {
          add(index)
        }
      }
    }
  }

  override fun maskBit(value: Char, mask: Char): Char = if (mask == '0') value else mask
}
