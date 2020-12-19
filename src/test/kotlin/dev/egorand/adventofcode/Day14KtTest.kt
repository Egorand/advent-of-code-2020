package dev.egorand.adventofcode

import org.junit.Test
import java.math.BigInteger
import kotlin.test.assertEquals

@ExperimentalStdlibApi
class Day14KtTest {
  @Test fun `Part 1 - Examples`() {
    val decoderChip = DecoderChipV1().apply {
      initializeProgram("""
          mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
          mem[8] = 11
          mem[7] = 101
          mem[8] = 0
          """.trimIndent().lines())
    }
    assertEquals(BigInteger("165"), decoderChip.sumAllValuesInMemory())
  }

  @Test fun `Part 1 - Input`() {
    val decoderChip = DecoderChipV1().apply {
      initializeProgram(readLines("inputs/day14"))
    }
    assertEquals(BigInteger("11501064782628"), decoderChip.sumAllValuesInMemory())
  }

  @Test fun `Part 2 - Examples`() {
    val decoderChip = DecoderChipV2().apply {
      initializeProgram("""
          mask = 000000000000000000000000000000X1001X
          mem[42] = 100
          mask = 00000000000000000000000000000000X0XX
          mem[26] = 1
          """.trimIndent().lines())
    }
    assertEquals(BigInteger("208"), decoderChip.sumAllValuesInMemory())
  }

  @Test fun `Part 2 - Input`() {
    val decoderChip = DecoderChipV2().apply {
      initializeProgram(readLines("inputs/day14"))
    }
    assertEquals(BigInteger("5142195937660"), decoderChip.sumAllValuesInMemory())
  }
}
