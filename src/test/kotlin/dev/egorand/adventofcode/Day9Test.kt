package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class Day9Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      127,
      findFirstInvalidNumber(
        numbers = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
        """.trimIndent().lines().map(String::toLong).toLongArray(),
        preambleSize = 5
      )
    )
    assertFailsWith<AssertionError> {
      findFirstInvalidNumber((1..26L).toLongArray(), preambleSize = 25)
    }
    assertFailsWith<AssertionError> {
      findFirstInvalidNumber((1..25L).toLongArray() + 49, preambleSize = 25)
    }
    assertEquals(100, findFirstInvalidNumber((1..25L).toLongArray() + 100, preambleSize = 25))
    assertEquals(50, findFirstInvalidNumber((1..25L).toLongArray() + 50, preambleSize = 25))
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(
      1721308972,
      findFirstInvalidNumber(readLongs("inputs/day9").toLongArray(), preambleSize = 25)
    )
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      62,
      contiguousRangeThatSumsTo(
        numbers = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
        """.trimIndent().lines().map(String::toLong).toLongArray(),
        sum = 127
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
      209694133,
      contiguousRangeThatSumsTo(readLongs("inputs/day9").toLongArray(), 1721308972)
    )
  }
}
