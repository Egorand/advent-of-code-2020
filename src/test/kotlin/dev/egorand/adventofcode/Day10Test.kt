package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day10Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
        35,
        findAdapterSequence(
            """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
            """.trimIndent().lines().map(String::toInt)
        )
    )
    assertEquals(
        220,
        findAdapterSequence(
            """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3
            """.trimIndent().lines().map(String::toInt)
        )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(2059, findAdapterSequence(readInts("inputs/day10")))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
        8,
        countAdapterCombinations(
            """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
            """.trimIndent().lines().map(String::toInt)
        )
    )
    assertEquals(
        19208,
        countAdapterCombinations(
            """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3
            """.trimIndent().lines().map(String::toInt)
        )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(86812553324672, countAdapterCombinations(readInts("inputs/day10")))
  }

  //    0 1 4 5 6 7 10 11 12 15 16 19
  //  0 0 1 0 0 0 0  0  0  0  0  0  0
  //  1 1 1 1 0 0 0  0  0  0  0  0  0
  //  4 0 0 0 0 0 0  0  0  0  0  0  0
  //  5 0 0 0 0 0 0  0  0  0  0  0  0
  //  6 0 0 0 0 0 0  0  0  0  0  0  0
  //  7 0 0 0 0 0 0  0  0  0  0  0  0
  // 10 0 0 0 0 0 0  0  0  0  0  0  0
  // 11 0 0 0 0 0 0  0  0  0  0  0  0
  // 12 0 0 0 0 0 0  0  0  0  0  0  0
  // 15 0 0 0 0 0 0  0  0  0  0  0  0
  // 16 0 0 0 0 0 0  0  0  0  0  0  0
  // 19 0 0 0 0 0 0  0  0  0  0  0  0
}
