package dev.egorand.adventofcode

import java.io.File

fun readInts(path: String): List<Int> = readLines(path).map(String::toInt)

fun readLines(path: String): List<String> = File(path).readLines()

fun readCharMatrix(path: String): Array<CharArray> =
  readLines(path).map { it.toCharArray() }.toTypedArray()

fun String.toCharMatrix(): Array<CharArray> {
  val lines = lines()
  return Array(lines.size) { index -> lines[index].toCharArray() }
}
