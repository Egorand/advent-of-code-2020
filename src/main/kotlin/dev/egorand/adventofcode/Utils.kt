package dev.egorand.adventofcode

import java.io.File

fun readInts(path: String): List<Int> = readLines(path).map(String::toInt)

fun readLines(path: String): List<String> = File(path).readLines()
