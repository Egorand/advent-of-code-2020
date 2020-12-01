package dev.egorand.adventofcode

/**
 * --- Part One ---
 *
 * Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle
 * input); apparently, something isn't quite adding up.
 *
 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those
 * two numbers together.
 *
 * For example, suppose your expense report contained the following:
 *
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 *
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together
 * produces 1721 * 299 = 514579, so the correct answer is 514579.
 *
 * Of course, your expense report is much larger. Find the two entries that sum to 2020; what do
 * you get if you multiply them together?
 *
 * --- Part Two ---
 *
 * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin
 * they had left over from a past vacation. They offer you a second one if you can find three
 * numbers in your expense report that meet the same criteria.
 *
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
 * Multiplying them together produces the answer, 241861950.
 *
 * In your expense report, what is the product of the three entries that sum to 2020?
 */

fun productOfTwoEntriesThatSumTo2020(entries: List<Int>): Long {
  val (first, second) = twoEntriesThatSumTo(entries, 2020)
    ?: throw AssertionError("No matches found!")
  return first.toLong() * second
}

private fun twoEntriesThatSumTo(entries: List<Int>, sum: Int): Pair<Int, Int>? {
  val remainders = mutableSetOf<Int>()
  for (n in entries) {
    if (n in remainders) {
      return n to sum - n
    }
    remainders += sum - n
  }
  return null
}

fun productOfThreeEntriesThatSumTo2020(entries: List<Int>): Long {
  for (n in entries) {
    val (first, second) = twoEntriesThatSumTo(entries - n, 2020 - n) ?: continue
    return n.toLong() * first * second
  }
  throw AssertionError("No matches found!")
}
