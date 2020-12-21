package dev.egorand.adventofcode

import dev.egorand.adventofcode.PrecedencePolicy.ADDITION_BEFORE_MULTIPLICATION
import dev.egorand.adventofcode.PrecedencePolicy.SAME_PRECEDENCE
import org.junit.Test
import kotlin.test.assertEquals

class Day18Test {
  @Test fun `Part 1 - Examples`() {
    val precedence = SAME_PRECEDENCE
    assertEquals(71, evaluate("1 + 2 * 3 + 4 * 5 + 6", precedence))
    assertEquals(51, evaluate("1 + (2 * 3) + (4 * (5 + 6))", precedence))
    assertEquals(26, evaluate("2 * 3 + (4 * 5)", precedence))
    assertEquals(437, evaluate("5 + (8 * 3 + 9 + 3 * 4 * 3)", precedence))
    assertEquals(12240, evaluate("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", precedence))
    assertEquals(13632, evaluate("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", precedence))
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(67800526776934, evaluateAll(readLines("inputs/day18"), SAME_PRECEDENCE))
  }

  @Test fun `Part 2 - Examples`() {
    val precedence = ADDITION_BEFORE_MULTIPLICATION
    assertEquals(231, evaluate("1 + 2 * 3 + 4 * 5 + 6", precedence))
    assertEquals(51, evaluate("1 + (2 * 3) + (4 * (5 + 6))", precedence))
    assertEquals(46, evaluate("2 * 3 + (4 * 5)", precedence))
    assertEquals(1445, evaluate("5 + (8 * 3 + 9 + 3 * 4 * 3)", precedence))
    assertEquals(669060, evaluate("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", precedence))
    assertEquals(23340, evaluate("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", precedence))
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
        340789638435483,
        evaluateAll(readLines("inputs/day18"), ADDITION_BEFORE_MULTIPLICATION)
    )
  }
}
