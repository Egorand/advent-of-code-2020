package dev.egorand.adventofcode

import java.io.File

// File reading utils

fun readText(path: String): String = File(path).readText()

fun readInts(path: String): List<Int> = readLines(path).map(String::toInt)

fun readLongs(path: String): List<Long> = readLines(path).map(String::toLong)

fun readLines(path: String): List<String> = File(path).readLines()

fun readCharMatrix(path: String): Array<CharArray> =
    readLines(path).map { it.toCharArray() }.toTypedArray()

fun readMaps(path: String): List<Map<String, String>> = parseIntoMaps(File(path).readText())

// Converters

fun LongRange.toLongArray(): LongArray = toList().toLongArray()

fun String.toCharMatrix(): Array<CharArray> {
  val lines = lines()
  return Array(lines.size) { index -> lines[index].toCharArray() }
}

fun Char.asDigit(): Int = this - '0'

// Parsers

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

fun String.parse(regex: Regex): MatchResult.Destructured = regex.matchEntire(this)!!.destructured

// Collection operators

fun <T, U> Iterable<T>.zipAll(other: Iterable<U>): List<Pair<T, U>> {
  return flatMap { first -> other.map { second -> first to second } }
}
