package dev.egorand.adventofcode

import dev.egorand.adventofcode.State.ACTIVE
import dev.egorand.adventofcode.State.INACTIVE

/**
 * --- Day 17: Conway Cubes ---
 *
 * As your flight slowly drifts through the sky, the Elves at the Mythical Information Bureau at
 * the North Pole contact you. They'd like some help debugging a malfunctioning experimental energy
 * source aboard one of their super-secret imaging satellites.
 *
 * The experimental energy source is based on cutting-edge technology: a set of Conway Cubes
 * contained in a pocket dimension! When you hear it's having problems, you can't help but agree to
 * take a look.
 *
 * The pocket dimension contains an infinite 3-dimensional grid. At every integer 3-dimensional
 * coordinate (x,y,z), there exists a single cube which is either active or inactive.
 *
 * In the initial state of the pocket dimension, almost all cubes start inactive. The only
 * exception to this is a small flat region of cubes (your puzzle input); the cubes in this region
 * start in the specified active (#) or inactive (.) state.
 *
 * The energy source then proceeds to boot up by executing six cycles.
 *
 * Each cube only ever considers its neighbors: any of the 26 other cubes where any of their
 * coordinates differ by at most 1. For example, given the cube at x=1,y=2,z=3, its neighbors
 * include the cube at x=2,y=2,z=2, the cube at x=0,y=2,z=3, and so on.
 *
 * During a cycle, all cubes simultaneously change their state according to the following rules:
 *
 * - If a cube is active and exactly 2 or 3 of its neighbors are also active, the cube remains
 *   active. Otherwise, the cube becomes inactive.
 * - If a cube is inactive but exactly 3 of its neighbors are active, the cube becomes active.
 *   Otherwise, the cube remains inactive.
 *
 * The engineers responsible for this experimental energy source would like you to simulate the
 * pocket dimension and determine what the configuration of cubes should be at the end of the
 * six-cycle boot process.
 *
 * For example, consider the following initial state:
 *
 * .#.
 * ..#
 * ###
 *
 * Even though the pocket dimension is 3-dimensional, this initial state represents a small
 * 2-dimensional slice of it. (In particular, this initial state defines a 3x3x1 region of the
 * 3-dimensional space.)
 *
 * Simulating a few cycles from this initial state produces the following configurations, where the
 * result of each cycle is shown layer-by-layer at each given z coordinate (and the frame of view
 * follows the active cells in each cycle):
 *
 * Before any cycles:
 *
 * z=0
 * .#.
 * ..#
 * ###
 *
 *
 * After 1 cycle:
 *
 * z=-1
 * #..
 * ..#
 * .#.
 *
 * z=0
 * #.#
 * .##
 * .#.
 *
 * z=1
 * #..
 * ..#
 * .#.
 *
 *
 * After 2 cycles:
 *
 * z=-2
 * .....
 * .....
 * ..#..
 * .....
 * .....
 *
 * z=-1
 * ..#..
 * .#..#
 * ....#
 * .#...
 * .....
 *
 * z=0
 * ##...
 * ##...
 * #....
 * ....#
 * .###.
 *
 * z=1
 * ..#..
 * .#..#
 * ....#
 * .#...
 * .....
 *
 * z=2
 * .....
 * .....
 * ..#..
 * .....
 * .....
 *
 *
 * After 3 cycles:
 *
 * z=-2
 * .......
 * .......
 * ..##...
 * ..###..
 * .......
 * .......
 * .......
 *
 * z=-1
 * ..#....
 * ...#...
 * #......
 * .....##
 * .#...#.
 * ..#.#..
 * ...#...
 *
 * z=0
 * ...#...
 * .......
 * #......
 * .......
 * .....##
 * .##.#..
 * ...#...
 *
 * z=1
 * ..#....
 * ...#...
 * #......
 * .....##
 * .#...#.
 * ..#.#..
 * ...#...
 *
 * z=2
 * .......
 * .......
 * ..##...
 * ..###..
 * .......
 * .......
 * .......
 *
 * After the full six-cycle boot process completes, 112 cubes are left in the active state.
 *
 * Starting with your given initial configuration, simulate six cycles. How many cubes are left in
 * the active state after the sixth cycle?
 */

class EnergySource private constructor(cubeStates: Map<Cube, State>) {
  private var cubeStates = cubeStates.toMutableMap()

  val activeCubes get() = cubeStates.count { (_, state) -> state == ACTIVE }

  fun boot(cycles: Int) {
    for (cycle in 1..cycles) {
      backfillAdjacentCubes(cubeStates)
      val updatedCubeStates = mutableMapOf<Cube, State>()
      for ((cube, state) in cubeStates) {
        val activeAdjacentNeighbors = cube.adjacentCubes().count { cubeStates[it] == ACTIVE }
        updatedCubeStates[cube] = when {
          state == ACTIVE && activeAdjacentNeighbors in 2..3 -> ACTIVE
          state == INACTIVE && activeAdjacentNeighbors == 3 -> ACTIVE
          else -> INACTIVE
        }
      }
      cubeStates = updatedCubeStates
    }
  }

  private fun backfillAdjacentCubes(energySource: MutableMap<Cube, State>) {
    // Copy keys into a new set to avoid concurrent modification.
    val cubes = energySource.keys.toSet()
    for (cube in cubes) {
      for (adjacentCube in cube.adjacentCubes()) {
        if (adjacentCube !in cubes) {
          energySource[adjacentCube] = INACTIVE
        }
      }
    }
  }

  private fun Cube.adjacentCubes(): Set<Cube> = buildSet {
    val cube = this@adjacentCubes
    for (x in cube.x - 1..cube.x + 1) {
      for (y in cube.y - 1..cube.y + 1) {
        for (z in cube.z - 1..cube.z + 1) {
          if (x != cube.x || y != cube.y || z != cube.z) {
            add(Cube(x, y, z))
          }
        }
      }
    }
  }

  override fun toString(): String {
    val cubes = cubeStates.keys
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE
    var minZ = Int.MAX_VALUE
    var maxZ = Int.MIN_VALUE
    for (cube in cubes) {
      if (cube.x < minX) minX = cube.x
      if (cube.x > maxX) maxX = cube.x
      if (cube.y < minY) minY = cube.y
      if (cube.y > maxY) maxY = cube.y
      if (cube.z < minZ) minZ = cube.z
      if (cube.z > maxZ) maxZ = cube.z
    }
    return buildString {
      for (z in minZ..maxZ) {
        append("z=$z\n")
        for (x in minX..maxX) {
          for (y in minY..maxY) {
            val cube = Cube(x, y, z)
            append(if (cubeStates[cube] == ACTIVE) '#' else '.')
          }
          appendLine()
        }
        appendLine()
      }
    }
  }

  companion object {
    fun with(initialConfiguration: String): EnergySource {
      val cubeStates = mutableMapOf<Cube, State>()
      var x = -1
      var y = -1
      for (line in initialConfiguration.lines()) {
        for (cube in line) {
          cubeStates[Cube(x, y, z = 0)] = if (cube == '#') ACTIVE else INACTIVE
          x += 1
        }
        y += 1
        x = -1
      }
      return EnergySource(cubeStates)
    }
  }
}

data class Cube(val x: Int, val y: Int, val z: Int)

enum class State {
  ACTIVE,
  INACTIVE,
}
