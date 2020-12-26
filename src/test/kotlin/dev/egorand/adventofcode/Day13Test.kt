package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day13Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      295,
      findEarliestBus(
        """
        939
        7,13,x,x,59,x,31,19
        """.trimIndent()
      )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(259, findEarliestBus(readText("inputs/day13")))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      3417.toBigInteger(),
      earliestTimestamp(
        """
        939
        17,x,13,19
        """.trimIndent()
      )
    )
    assertEquals(
      754018.toBigInteger(),
      earliestTimestamp(
        """
        939
        67,7,59,61
        """.trimIndent()
      )
    )
    assertEquals(
      779210.toBigInteger(),
      earliestTimestamp(
        """
        939
        67,x,7,59,61
        """.trimIndent()
      )
    )
    assertEquals(
      1261476.toBigInteger(),
      earliestTimestamp(
        """
        939
        67,7,x,59,61
        """.trimIndent()
      )
    )
    assertEquals(
      1202161486.toBigInteger(),
      earliestTimestamp(
        """
        939
        1789,37,47,1889
        """.trimIndent()
      )
    )
    assertEquals(
      1068781.toBigInteger(),
      earliestTimestamp(
        """
        939
        7,13,x,x,59,x,31,19
        """.trimIndent()
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(210612924879242.toBigInteger(), earliestTimestamp(readText("inputs/day13")))
  }
}
