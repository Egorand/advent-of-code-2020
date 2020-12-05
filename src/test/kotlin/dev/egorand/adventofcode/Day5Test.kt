package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day5Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(357, findSeat(boardingPass = "FBFBBFFRLR").id)
    assertEquals(567, findSeat(boardingPass = "BFFFBBFRRR").id)
    assertEquals(119, findSeat(boardingPass = "FFFBBBFRRR").id)
    assertEquals(820, findSeat(boardingPass = "BBFFBBFRLL").id)
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(913, highestSeatId(readLines("inputs/day5")))
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(717, findMissingSeat(readLines("inputs/day5")).id)
  }
}
