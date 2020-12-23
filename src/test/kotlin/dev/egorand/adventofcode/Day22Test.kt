package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day22Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      306,
      SimpleCrabCombat.play(
        """
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
    assertEquals(29764, SimpleCrabCombat.play(readText("inputs/day22")))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      291,
      RecursiveCrabCombat().play(
        """
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

  @Test fun `Part 2 - Input`() {
    assertEquals(32588, RecursiveCrabCombat().play(readText("inputs/day22")))
  }
}
