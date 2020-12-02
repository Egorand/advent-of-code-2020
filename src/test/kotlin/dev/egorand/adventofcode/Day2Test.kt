package dev.egorand.adventofcode

import dev.egorand.adventofcode.PasswordPolicy.MIN_MAX_OCCURRENCES
import dev.egorand.adventofcode.PasswordPolicy.THE_OFFICIAL_TOBOGGAN_CORPORATE_POLICY
import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {
  @Test fun `Part 1 - Example`() {
    assertEquals(
      2,
      countValidPasswords(
        listOf(
          "1-3 a: abcde",
          "1-3 b: cdefg",
          "2-9 c: ccccccccc",
        ),
        passwordPolicy = MIN_MAX_OCCURRENCES,
      )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(
      660,
      countValidPasswords(
        readLines("inputs/day2"),
        passwordPolicy = MIN_MAX_OCCURRENCES
      )
    )
  }

  @Test fun `Part 2 - Example`() {
    assertEquals(
      1,
      countValidPasswords(
        listOf(
          "1-3 a: abcde",
          "1-3 b: cdefg",
          "2-9 c: ccccccccc",
        ),
        passwordPolicy = THE_OFFICIAL_TOBOGGAN_CORPORATE_POLICY,
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
      530,
      countValidPasswords(
        readLines("inputs/day2"),
        passwordPolicy = THE_OFFICIAL_TOBOGGAN_CORPORATE_POLICY
      )
    )
  }
}