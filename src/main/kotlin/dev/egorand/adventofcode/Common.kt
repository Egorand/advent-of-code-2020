package dev.egorand.adventofcode

data class Seat(
  val row: Int,
  val seat: Int
) {
  constructor(seat: Pair<Int, Int>) : this(seat.first, seat.second)
}
