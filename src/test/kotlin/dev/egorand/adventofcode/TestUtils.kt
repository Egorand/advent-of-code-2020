package dev.egorand.adventofcode

import kotlin.test.fail

fun <T> assertContentDeepEquals(expected: Array<T>, actual: Array<T>) {
  if (!expected.contentDeepEquals(actual)) {
    fail("""
      Contents not equal.
      Expected: ${expected.contentDeepToString()}
      Actual: ${actual.contentDeepToString()}
      """.trimIndent())
  }
}
