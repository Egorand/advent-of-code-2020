package dev.egorand.adventofcode

import dev.egorand.adventofcode.SeatLookaroundStrategy.ADJACENT
import dev.egorand.adventofcode.SeatLookaroundStrategy.VISIBLE_IN_EACH_DIRECTION
import org.junit.Test
import kotlin.test.assertEquals

class Day11Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
        37,
        countOccupiedSeats(
            seatMap = """
              L.LL.LL.LL
              LLLLLLL.LL
              L.L.L..L..
              LLLL.LL.LL
              L.LL.LL.LL
              L.LLLLL.LL
              ..L.L.....
              LLLLLLLLLL
              L.LLLLLL.L
              L.LLLLL.LL
              """.trimIndent().toCharMatrix(),
            seatLookaroundStrategy = ADJACENT,
        )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(
        2247,
        countOccupiedSeats(
            seatMap = readCharMatrix("inputs/day11"),
            seatLookaroundStrategy = ADJACENT,
        )
    )
  }

  @Test fun `Part 2 - Examples`() {
    var seatMap = """
      .......#.
      ...#.....
      .#.......
      .........
      ..#L....#
      ....#....
      .........
      #........
      ...#.....
      """.trimIndent().toCharMatrix()
    assertEquals(Seat(2, 1), nextVisibleSeatInDirection(seatMap, Seat(4, 3), -1, -1))
    assertEquals(Seat(1, 3), nextVisibleSeatInDirection(seatMap, Seat(4, 3), -1, 0))
    assertEquals(Seat(0, 7), nextVisibleSeatInDirection(seatMap, Seat(4, 3), -1, 1))
    assertEquals(Seat(4, 2), nextVisibleSeatInDirection(seatMap, Seat(4, 3), 0, -1))
    assertEquals(Seat(4, 8), nextVisibleSeatInDirection(seatMap, Seat(4, 3), 0, 1))
    assertEquals(Seat(7, 0), nextVisibleSeatInDirection(seatMap, Seat(4, 3), 1, -1))
    assertEquals(Seat(8, 3), nextVisibleSeatInDirection(seatMap, Seat(4, 3), 1, 0))
    assertEquals(Seat(5, 4), nextVisibleSeatInDirection(seatMap, Seat(4, 3), 1, 1))
    assertEquals(
        listOf('#', '#', '#', '#', '#', '#', '#', '#'),
        visibleSeats(seatMap, Seat(4, 3)),
    )

    seatMap = """
      .............
      .L.L.#.#.#.#.
      .............      
      """.trimIndent().toCharMatrix()
    assertEquals(Seat(1, 3), nextVisibleSeatInDirection(seatMap, Seat(1, 1), 0, 1))
    assertEquals(listOf('L'), visibleSeats(seatMap, Seat(1, 1)))

    seatMap = """
      .##.##.
      #.#.#.#
      ##...##
      ...L...
      ##...##
      #.#.#.#
      .##.##.      
      """.trimIndent().toCharMatrix()
    assertEquals(emptyList(), visibleSeats(seatMap, Seat(3, 3)))

    assertContentDeepEquals(
        """
          #.##.##.##
          #######.##
          #.#.#..#..
          ####.##.##
          #.##.##.##
          #.#####.##
          ..#.#.....
          ##########
          #.######.#
          #.#####.##
          """.trimIndent().toCharMatrix(),
        updateSeatMap(
            seatMap = """
              L.LL.LL.LL
              LLLLLLL.LL
              L.L.L..L..
              LLLL.LL.LL
              L.LL.LL.LL
              L.LLLLL.LL
              ..L.L.....
              LLLLLLLLLL
              L.LLLLLL.L
              L.LLLLL.LL
              """.trimIndent().toCharMatrix(),
            seatLookaroundStrategy = VISIBLE_IN_EACH_DIRECTION,
        ).seatMap
    )

    assertContentDeepEquals(
        """
          #.LL.LL.L#
          #LLLLLL.LL
          L.L.L..L..
          LLLL.LL.LL
          L.LL.LL.LL
          L.LLLLL.LL
          ..L.L.....
          LLLLLLLLL#
          #.LLLLLL.L
          #.LLLLL.L#
          """.trimIndent().toCharMatrix(),
        updateSeatMap(
            seatMap = """
              #.##.##.##
              #######.##
              #.#.#..#..
              ####.##.##
              #.##.##.##
              #.#####.##
              ..#.#.....
              ##########
              #.######.#
              #.#####.##
              """.trimIndent().toCharMatrix(),
            seatLookaroundStrategy = VISIBLE_IN_EACH_DIRECTION,
        ).seatMap
    )

    assertEquals(
        26,
        countOccupiedSeats(
            seatMap = """
              L.LL.LL.LL
              LLLLLLL.LL
              L.L.L..L..
              LLLL.LL.LL
              L.LL.LL.LL
              L.LLLLL.LL
              ..L.L.....
              LLLLLLLLLL
              L.LLLLLL.L
              L.LLLLL.LL
              """.trimIndent().toCharMatrix(),
            seatLookaroundStrategy = VISIBLE_IN_EACH_DIRECTION,
        )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
        2011,
        countOccupiedSeats(
            seatMap = readCharMatrix("inputs/day11"),
            seatLookaroundStrategy = VISIBLE_IN_EACH_DIRECTION,
        )
    )
  }
}
