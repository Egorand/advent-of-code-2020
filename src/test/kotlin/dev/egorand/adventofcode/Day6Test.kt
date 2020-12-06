package dev.egorand.adventofcode

import dev.egorand.adventofcode.Mode.ANYONE_ANSWERED
import dev.egorand.adventofcode.Mode.EVERYONE_ANSWERED
import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      6,
      countAnswers(
        """
        abcx
        abcy
        abcz
        """.trimIndent(),
        mode = ANYONE_ANSWERED,
      )
    )
    assertEquals(
      11,
      countAnswers(
        """
        abc

        a
        b
        c
        
        ab
        ac
        
        a
        a
        a
        a
        
        b
        """.trimIndent(),
        mode = ANYONE_ANSWERED,
      )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(6506, countAnswers(readText("inputs/day6"), mode = ANYONE_ANSWERED))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      6,
      countAnswers(
        """
        abc

        a
        b
        c
        
        ab
        ac
        
        a
        a
        a
        a
        
        b
        """.trimIndent(),
        mode = EVERYONE_ANSWERED,
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(3243, countAnswers(readText("inputs/day6"), mode = EVERYONE_ANSWERED))
  }
}
