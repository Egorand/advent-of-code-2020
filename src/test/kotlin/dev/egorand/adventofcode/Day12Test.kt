package dev.egorand.adventofcode

import dev.egorand.adventofcode.Bearing.EAST
import dev.egorand.adventofcode.Bearing.NORTH
import dev.egorand.adventofcode.Bearing.SOUTH
import dev.egorand.adventofcode.Bearing.WEST
import org.junit.Test
import kotlin.test.assertEquals

class Day12Test {
  @Test fun bearing() {
    assertEquals(NORTH, EAST - 90)
    assertEquals(WEST, EAST - 180)
    assertEquals(SOUTH, EAST - 270)
    assertEquals(SOUTH, EAST + 90)
    assertEquals(WEST, EAST + 180)
    assertEquals(NORTH, EAST + 270)
  }

  @Test fun `Part 1 - Examples`() {
    val navigator = ShipNavigator()
    val instructions = """
      F10
      N3
      F7
      R90
      F11
      """.trimIndent()
    assertEquals(25, navigator.navigate(instructions.lines()))
  }

  @Test fun `Part 1 - Input`() {
    val navigator = ShipNavigator()
    assertEquals(1424, navigator.navigate(readLines("inputs/day12")))
  }

  @Test fun `Part 2 - Examples`() {
    val navigator = WaypointNavigator()
    val instructions = """
      F10
      N3
      F7
      R90
      F11
      """.trimIndent()
    assertEquals(286, navigator.navigate(instructions.lines()))
  }

  @Test fun `Part 2 - Input`() {
    val navigator = WaypointNavigator()
    assertEquals(63447, navigator.navigate(readLines("inputs/day12")))
  }
}
