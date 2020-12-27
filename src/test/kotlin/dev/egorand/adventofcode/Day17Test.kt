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
    assertEquals(5, bootAndCountActiveCubes(configuration, cycles = 0))
    assertEquals(11, bootAndCountActiveCubes(configuration, cycles = 1))
    assertEquals(21, bootAndCountActiveCubes(configuration, cycles = 2))
    assertEquals(38, bootAndCountActiveCubes(configuration, cycles = 3))
    assertEquals(112, bootAndCountActiveCubes(configuration, cycles = 6))
  }

  private fun bootAndCountActiveCubes(initialConfiguration: String, cycles: Int): Int {
    val energySource = EnergySource.with(initialConfiguration)
    energySource.boot(cycles)
    return energySource.activeCubes
  }

  @Test fun `Part 1 - Input`() {
    val energySource = EnergySource.with(readText("inputs/day17"))
    energySource.boot(cycles = 6)
    assertEquals(372, energySource.activeCubes)
  }
}
