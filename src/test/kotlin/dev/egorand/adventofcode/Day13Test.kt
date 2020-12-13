package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day13Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
        295,
        findEarliestBus("""
          939
          7,13,x,x,59,x,31,19
          """.trimIndent())
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(259, findEarliestBus(readText("inputs/day13")))
  }
}
