package dev.egorand.adventofcode

import java.io.File

fun readIntsFromFile(path: String): List<Int> {
  return File(path).readLines().map { it.toInt() }
}
