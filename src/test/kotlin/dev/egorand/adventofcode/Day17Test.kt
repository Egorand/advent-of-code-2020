package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day17Test {
  @Test fun `Part 1 - Examples`() {
    val configuration = """
      .#.
      ..#
      ###
      """.trimIndent()
    assertEquals(5, bootAndCountActiveCubes(configuration, bootCycles = 0))
    assertEquals(11, bootAndCountActiveCubes(configuration, bootCycles = 1))
    assertEquals(21, bootAndCountActiveCubes(configuration, bootCycles = 2))
    assertEquals(38, bootAndCountActiveCubes(configuration, bootCycles = 3))
    assertEquals(112, bootAndCountActiveCubes(configuration, bootCycles = 6))
  }

  private fun bootAndCountActiveCubes(initialConfiguration: String, bootCycles: Int): Int {
    val energySource = energySource3D(initialConfiguration, bootCycles)
    return energySource.activeCubes
  }

  @Test fun `Part 1 - Input`() {
    val energySource = energySource3D(configuration = readText("inputs/day17"), bootCycles = 6)
    assertEquals(372, energySource.activeCubes)
  }

  @Test fun `Part 2 - Examples`() {
    val energySource = energySource4D(
      configuration = """
      .#.
      ..#
      ###
      """.trimIndent(),
      bootCycles = 6,
    )
    assertEquals(848, energySource.activeCubes)
  }

  @Test fun `Part 2 - Input`() {
    val energySource = energySource4D(configuration = readText("inputs/day17"), bootCycles = 6)
    assertEquals(1896, energySource.activeCubes)
  }
}
