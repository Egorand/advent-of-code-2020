package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day23Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals("2,5,4,6,7,3,8,9", mixCups("389125467", moves = 0).toString())

    assertEquals("5,4,6,7,3,2,8,9", mixCups("389125467", moves = 1).toString())
    assertEquals("3,2,5,4,6,7,8,9", mixCups("389125467", moves = 2).toString())
    assertEquals("3,4,6,7,2,5,8,9", mixCups("389125467", moves = 3).toString())
    assertEquals("3,2,5,8,4,6,7,9", mixCups("389125467", moves = 4).toString())
    assertEquals("3,6,7,9,2,5,8,4", mixCups("389125467", moves = 5).toString())
    assertEquals("9,3,6,7,2,5,8,4", mixCups("389125467", moves = 6).toString())
    assertEquals("9,2,5,8,3,6,7,4", mixCups("389125467", moves = 7).toString())
    assertEquals("5,8,3,9,2,6,7,4", mixCups("389125467", moves = 8).toString())
    assertEquals("8,3,9,2,6,5,7,4", mixCups("389125467", moves = 9).toString())
    assertEquals("9,2,6,5,8,3,7,4", mixCups("389125467", moves = 10).toString())
  }

  @Test fun `Part 1 - Input`() {
    assertEquals("2,8,9,4,6,7,5,3", mixCups("586439172", moves = 100).toString())
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals("2,5,4,6,7,10,3,8,9", mixCups("389125467", moves = 0, padTo = 10).toString())
  }

  @Test fun `Part 2 - Input`() {
    val first = mixCups("586439172", padTo = 1_000_000, moves = 10_000_000)
    val second = first.next.value
    val third = first.next.next.value
    assertEquals(1, first.value)
    assertEquals(712360, second)
    assertEquals(728626, third)
    assertEquals(519044017360, second.toLong() * third)
  }
}
