package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day11Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
        37,
        countOccupiedSeats(
            seatMap = """
              L.LL.LL.LL
              LLLLLLL.LL
              L.L.L..L..
              LLLL.LL.LL
              L.LL.LL.LL
              L.LLLLL.LL
              ..L.L.....
              LLLLLLLLLL
              L.LLLLLL.L
              L.LLLLL.LL
              """.trimIndent().toCharMatrix()
        )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(2247, countOccupiedSeats(seatMap = readCharMatrix("inputs/day11")))
  }
}
