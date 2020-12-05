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

fun parseIntoMaps(input: String): List<Map<String, String>> {
  val maps = mutableListOf<Map<String, String>>()
  val lines = input.split("\n\n")
  for (line in lines) {
    val map = mutableMapOf<String, String>()
    val pairs = line.split(Regex("\\s"))
    for (pair in pairs) {
      val (key, value) = pair.split(":")
      map[key] = value
    }
    maps += map
  }
  return maps
}

fun readMaps(path: String): List<Map<String, String>> = parseIntoMaps(File(path).readText())

fun <T, U> Iterable<T>.zipAll(other: Iterable<U>): List<Pair<T, U>> {
  return flatMap { first -> other.map { second -> first to second } }
}
