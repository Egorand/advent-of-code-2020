package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day15Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(0, lastNumberSpoken(intArrayOf(0, 3, 6), 4))
    assertEquals(3, lastNumberSpoken(intArrayOf(0, 3, 6), 5))
    assertEquals(3, lastNumberSpoken(intArrayOf(0, 3, 6), 6))
    assertEquals(1, lastNumberSpoken(intArrayOf(0, 3, 6), 7))
    assertEquals(0, lastNumberSpoken(intArrayOf(0, 3, 6), 8))
    assertEquals(4, lastNumberSpoken(intArrayOf(0, 3, 6), 9))
    assertEquals(0, lastNumberSpoken(intArrayOf(0, 3, 6), 10))

    assertEquals(1, lastNumberSpoken(intArrayOf(1, 3, 2), 2020))
    assertEquals(10, lastNumberSpoken(intArrayOf(2, 1, 3), 2020))
    assertEquals(27, lastNumberSpoken(intArrayOf(1, 2, 3), 2020))
    assertEquals(78, lastNumberSpoken(intArrayOf(2, 3, 1), 2020))
    assertEquals(438, lastNumberSpoken(intArrayOf(3, 2, 1), 2020))
    assertEquals(1836, lastNumberSpoken(intArrayOf(3, 1, 2), 2020))
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(1085, lastNumberSpoken(intArrayOf(1, 20, 11, 6, 12, 0), 2020))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(175594, lastNumberSpoken(intArrayOf(0, 3, 6), 30_000_000))
    assertEquals(2578, lastNumberSpoken(intArrayOf(1, 3, 2), 30_000_000))
    assertEquals(3544142, lastNumberSpoken(intArrayOf(2, 1, 3), 30_000_000))
    assertEquals(261214, lastNumberSpoken(intArrayOf(1, 2, 3), 30_000_000))
    assertEquals(6895259, lastNumberSpoken(intArrayOf(2, 3, 1), 30_000_000))
    assertEquals(18, lastNumberSpoken(intArrayOf(3, 2, 1), 30_000_000))
    assertEquals(362, lastNumberSpoken(intArrayOf(3, 1, 2), 30_000_000))
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(10652, lastNumberSpoken(intArrayOf(1, 20, 11, 6, 12, 0), 30_000_000))
  }
}
