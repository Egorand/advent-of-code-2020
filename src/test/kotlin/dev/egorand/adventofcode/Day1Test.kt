package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {
  @Test fun `Part 1 - Example`() {
    assertEquals(
      514579,
      productOfTwoEntriesThatSumTo2020(listOf(1721, 979, 366, 299, 675, 1456))
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(
      539851,
      productOfTwoEntriesThatSumTo2020(readInts("inputs/day1"))
    )
  }

  @Test fun `Part 2 - Example`() {
    assertEquals(
      241861950,
      productOfThreeEntriesThatSumTo2020(listOf(1721, 979, 366, 299, 675, 1456))
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
      212481360,
      productOfThreeEntriesThatSumTo2020(readInts("inputs/day1"))
    )
  }
}
