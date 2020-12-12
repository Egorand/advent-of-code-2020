package dev.egorand.adventofcode

import dev.egorand.adventofcode.SeatLookaroundStrategy.ADJACENT
import dev.egorand.adventofcode.SeatLookaroundStrategy.VISIBLE_IN_EACH_DIRECTION

/**
 *  * --- Day 11: Seating System ---
 *
 * Your plane lands with plenty of time to spare. The final leg of your journey is a ferry that
 * goes directly to the tropical island where you can finally start your vacation. As you reach the
 * waiting area to board the ferry, you realize you're so early, nobody else has even arrived yet!
 *
 * By modeling the process people use to choose (or abandon) their seat in the waiting area, you're
 * pretty sure you can predict the best place to sit. You make a quick map of the seat layout (your
 * puzzle input).
 *
 * The seat layout fits neatly on a grid. Each position is either floor (.), an empty seat (L), or
 * an occupied seat (#). For example, the initial seat layout might look like this:
 *
 * L.LL.LL.LL
 * LLLLLLL.LL
 * L.L.L..L..
 * LLLL.LL.LL
 * L.LL.LL.LL
 * L.LLLLL.LL
 * ..L.L.....
 * LLLLLLLLLL
 * L.LLLLLL.L
 * L.LLLLL.LL
 *
 * Now, you just need to model the people who will be arriving shortly. Fortunately, people are
 * entirely predictable and always follow a simple set of rules. All decisions are based on the
 * number of occupied seats adjacent to a given seat (one of the eight positions immediately up,
 * down, left, right, or diagonal from the seat). The following rules are applied to every seat
 * simultaneously:
 *
 * - If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes
 *   occupied.
 * - If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat
 *   becomes empty.
 * - Otherwise, the seat's state does not change.
 *
 * Floor (.) never changes; seats don't move, and nobody sits on the floor.
 *
 * After one round of these rules, every seat in the example layout becomes occupied:
 *
 * #.##.##.##
 * #######.##
 * #.#.#..#..
 * ####.##.##
 * #.##.##.##
 * #.#####.##
 * ..#.#.....
 * ##########
 * #.######.#
 * #.#####.##
 *
 * After a second round, the seats with four or more occupied adjacent seats become empty again:
 *
 * #.LL.L#.##
 * #LLLLLL.L#
 * L.L.L..L..
 * #LLL.LL.L#
 * #.LL.LL.LL
 * #.LLLL#.##
 * ..L.L.....
 * #LLLLLLLL#
 * #.LLLLLL.L
 * #.#LLLL.##
 *
 * This process continues for three more rounds:
 *
 * #.##.L#.##
 * #L###LL.L#
 * L.#.#..#..
 * #L##.##.L#
 * #.##.LL.LL
 * #.###L#.##
 * ..#.#.....
 * #L######L#
 * #.LL###L.L
 * #.#L###.##
 *
 * #.#L.L#.##
 * #LLL#LL.L#
 * L.L.L..#..
 * #LLL.##.L#
 * #.LL.LL.LL
 * #.LL#L#.##
 * ..L.L.....
 * #L#LLLL#L#
 * #.LLLLLL.L
 * #.#L#L#.##
 *
 * #.#L.L#.##
 * #LLL#LL.L#
 * L.#.L..#..
 * #L##.##.L#
 * #.#L.LL.LL
 * #.#L#L#.##
 * ..L.L.....
 * #L#L##L#L#
 * #.LLLLLL.L
 * #.#L#L#.##
 *
 * At this point, something interesting happens: the chaos stabilizes and further applications of
 * these rules cause no seats to change state! Once people stop moving around, you count 37
 * occupied seats.
 *
 * Simulate your seating area by applying the seating rules repeatedly until no seats change state.
 * How many seats end up occupied?
 *
 * --- Part Two ---
 *
 * As soon as people start to arrive, you realize your mistake. People don't just care about
 * adjacent seats - they care about the first seat they can see in each of those eight directions!
 *
 * Now, instead of considering just the eight immediately adjacent seats, consider the first seat
 * in each of those eight directions. For example, the empty seat below would see eight occupied
 * seats:
 *
 * .......#.
 * ...#.....
 * .#.......
 * .........
 * ..#L....#
 * ....#....
 * .........
 * #........
 * ...#.....
 *
 * The leftmost empty seat below would only see one empty seat, but cannot see any of the occupied
 * ones:
 *
 * .............
 * .L.L.#.#.#.#.
 * .............
 *
 * The empty seat below would see no occupied seats:
 *
 * .##.##.
 * #.#.#.#
 * ##...##
 * ...L...
 * ##...##
 * #.#.#.#
 * .##.##.
 *
 * Also, people seem to be more tolerant than you expected: it now takes five or more visible
 * occupied seats for an occupied seat to become empty (rather than four or more from the previous
 * rules). The other rules still apply: empty seats that see no occupied seats become occupied,
 * seats matching no rule don't change, and floor never changes.
 *
 * Given the same starting layout as above, these new rules cause the seating area to shift around
 * as follows:
 *
 * L.LL.LL.LL
 * LLLLLLL.LL
 * L.L.L..L..
 * LLLL.LL.LL
 * L.LL.LL.LL
 * L.LLLLL.LL
 * ..L.L.....
 * LLLLLLLLLL
 * L.LLLLLL.L
 * L.LLLLL.LL
 *
 * #.##.##.##
 * #######.##
 * #.#.#..#..
 * ####.##.##
 * #.##.##.##
 * #.#####.##
 * ..#.#.....
 * ##########
 * #.######.#
 * #.#####.##
 *
 * #.LL.LL.L#
 * #LLLLLL.LL
 * L.L.L..L..
 * LLLL.LL.LL
 * L.LL.LL.LL
 * L.LLLLL.LL
 * ..L.L.....
 * LLLLLLLLL#
 * #.LLLLLL.L
 * #.LLLLL.L#
 *
 * #.L#.##.L#
 * #L#####.LL
 * L.#.#..#..
 * ##L#.##.##
 * #.##.#L.##
 * #.#####.#L
 * ..#.#.....
 * LLL####LL#
 * #.L#####.L
 * #.L####.L#
 *
 * #.L#.L#.L#
 * #LLLLLL.LL
 * L.L.L..#..
 * ##LL.LL.L#
 * L.LL.LL.L#
 * #.LLLLL.LL
 * ..L.L.....
 * LLLLLLLLL#
 * #.LLLLL#.L
 * #.L#LL#.L#
 *
 * #.L#.L#.L#
 * #LLLLLL.LL
 * L.L.L..#..
 * ##L#.#L.L#
 * L.L#.#L.L#
 * #.L####.LL
 * ..#.#.....
 * LLL###LLL#
 * #.LLLLL#.L
 * #.L#LL#.L#
 *
 * #.L#.L#.L#
 * #LLLLLL.LL
 * L.L.L..#..
 * ##L#.#L.L#
 * L.L#.LL.L#
 * #.LLLL#.LL
 * ..#.L.....
 * LLL###LLL#
 * #.LLLLL#.L
 * #.L#LL#.L#
 *
 * Again, at this point, people stop shifting around and the seating area reaches equilibrium. Once
 * this occurs, you count 26 occupied seats.
 *
 * Given the new visibility method and the rule change for occupied seats becoming empty, once
 * equilibrium is reached, how many seats end up occupied?
 */

enum class SeatLookaroundStrategy {
  ADJACENT,
  VISIBLE_IN_EACH_DIRECTION,
}

fun countOccupiedSeats(
  seatMap: Array<CharArray>,
  seatLookaroundStrategy: SeatLookaroundStrategy,
): Int {
  var currentSeatMap = seatMap
  while (true) {
    val updatedSeatMap = updateSeatMap(currentSeatMap, seatLookaroundStrategy)
    if (updatedSeatMap.sameAsOriginalSeatMap) {
      return updatedSeatMap.occupiedSeatsInSeatMap
    }
    currentSeatMap = updatedSeatMap.seatMap
  }
}

class UpdatedSeatMap(
  val seatMap: Array<CharArray>,
  val occupiedSeatsInSeatMap: Int,
  val sameAsOriginalSeatMap: Boolean,
)

fun updateSeatMap(
  seatMap: Array<CharArray>,
  seatLookaroundStrategy: SeatLookaroundStrategy
): UpdatedSeatMap {
  val updatedSeatMap = Array(seatMap.size) { CharArray(seatMap[0].size) }
  var occupiedSeatsInUpdatedSeatMap = 0
  var sameAsOriginalSeatMap = true
  for (i in seatMap.indices) {
    for (j in seatMap[i].indices) {
      val adjacentSeats = when (seatLookaroundStrategy) {
        ADJACENT -> adjacentSeats(seatMap, Seat(i, j))
        VISIBLE_IN_EACH_DIRECTION -> visibleSeats(seatMap, Seat(i, j))
      }
      val minOccupiedAdjacentSeatsToTurnEmpty = when (seatLookaroundStrategy) {
        ADJACENT -> 4
        VISIBLE_IN_EACH_DIRECTION -> 5
      }
      updatedSeatMap[i][j] = when (val seat = seatMap[i][j]) {
        '.' -> '.'
        'L' -> if (adjacentSeats.none { it == '#' }) '#' else seat
        '#' -> if (adjacentSeats.count { it == '#' } >= minOccupiedAdjacentSeatsToTurnEmpty) {
          'L'
        } else {
          seat
        }
        else -> seat
      }
      if (updatedSeatMap[i][j] == '#') occupiedSeatsInUpdatedSeatMap += 1
      if (updatedSeatMap[i][j] != seatMap[i][j]) sameAsOriginalSeatMap = false
    }
  }
  return UpdatedSeatMap(updatedSeatMap, occupiedSeatsInUpdatedSeatMap, sameAsOriginalSeatMap)
}

fun adjacentSeats(seatMap: Array<CharArray>, seat: Seat): List<Char> {
  return mutableListOf<Char>().apply {
    val (row, seat) = seat
    for (i in row - 1..row + 1) {
      for (j in seat - 1..seat + 1) {
        if ((i != row || j != seat) && i in seatMap.indices && j in seatMap[row].indices) {
          add(seatMap[i][j])
        }
      }
    }
  }
}

fun visibleSeats(seatMap: Array<CharArray>, seat: Seat): List<Char> {
  return listOfNotNull(
      nextVisibleSeatInDirection(seatMap, seat, directionRow = -1, directionSeat = -1),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = -1, directionSeat = 0),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = -1, directionSeat = 1),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = 0, directionSeat = -1),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = 0, directionSeat = 1),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = 1, directionSeat = -1),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = 1, directionSeat = 0),
      nextVisibleSeatInDirection(seatMap, seat, directionRow = 1, directionSeat = 1),
  ).map { (row, seat) -> seatMap[row][seat] }
}

fun nextVisibleSeatInDirection(
  seatMap: Array<CharArray>,
  seat: Seat,
  directionRow: Int,
  directionSeat: Int,
): Seat? {
  var nextSeat = Seat(row = seat.row + directionRow, seat = seat.seat + directionSeat)
  while (nextSeat.row in seatMap.indices && nextSeat.seat in seatMap[nextSeat.row].indices) {
    val nextSeatState = seatMap[nextSeat.row][nextSeat.seat]
    if (nextSeatState == 'L' || nextSeatState == '#') {
      return nextSeat
    }
    nextSeat = Seat(row = nextSeat.row + directionRow, seat = nextSeat.seat + directionSeat)
  }
  return null
}
