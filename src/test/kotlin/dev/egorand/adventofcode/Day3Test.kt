package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {
  private val exampleMap = """
    ..##.......
    #...#...#..
    .#....#..#.
    ..#.#...#.#
    .#...##..#.
    ..#.##.....
    .#.#.#....#
    .#........#
    #.##...#...
    #...##....#
    .#..#...#.#
    """.trimIndent().toCharMatrix()
  private val inputMap = readCharMatrix("inputs/day3")

  @Test fun `Part 1 - Example`() {
    assertEquals(7, treesEncountered(exampleMap, Slope(right = 3, down = 1)))
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(282, treesEncountered(inputMap, Slope(right = 3, down = 1)))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(2, treesEncountered(exampleMap, Slope(right = 1, down = 1)))
    assertEquals(7, treesEncountered(exampleMap, Slope(right = 3, down = 1)))
    assertEquals(3, treesEncountered(exampleMap, Slope(right = 5, down = 1)))
    assertEquals(4, treesEncountered(exampleMap, Slope(right = 7, down = 1)))
    assertEquals(2, treesEncountered(exampleMap, Slope(right = 1, down = 2)))
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(53, treesEncountered(inputMap, Slope(right = 1, down = 1)))
    assertEquals(282, treesEncountered(inputMap, Slope(right = 3, down = 1)))
    assertEquals(54, treesEncountered(inputMap, Slope(right = 5, down = 1)))
    assertEquals(54, treesEncountered(inputMap, Slope(right = 7, down = 1)))
    assertEquals(22, treesEncountered(inputMap, Slope(right = 1, down = 2)))
  }
}
