package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day22Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
        306,
        crabCombat("""
            Player 1:
            9
            2
            6
            3
            1

            Player 2:
            5
            8
            4
            7
            10
            """.trimIndent()
        )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(29764, crabCombat(readText("inputs/day22")))
  }
}
