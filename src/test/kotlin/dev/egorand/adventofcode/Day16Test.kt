package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day16Test {
  @Test fun `Part 1 - Examples`() {
    val ticketScanner = TicketScanner(
      notes = """
        class: 1-3 or 5-7
        row: 6-11 or 33-44
        seat: 13-40 or 45-50

        your ticket:
        7,1,14

        nearby tickets:
        7,3,47
        40,4,50
        55,2,20
        38,6,12
        """.trimIndent(),
      orderFields = false,
    )
    assertEquals(71, ticketScanner.scanningErrorRate)
  }

  @Test fun `Part 1 - Input`() {
    val ticketScanner = TicketScanner(notes = readText("inputs/day16"), orderFields = false)
    assertEquals(24021, ticketScanner.scanningErrorRate)
  }

  @Test fun `Part 2 - Examples`() {
    val ticketScanner = TicketScanner(
      notes = """
        class: 0-1 or 4-19
        row: 0-5 or 8-19
        seat: 0-13 or 16-19
        
        your ticket:
        11,12,13
        
        nearby tickets:
        3,9,18
        15,1,5
        5,14,9
        """.trimIndent()
    )
    assertEquals(12, ticketScanner.yourTicketValueForField("class"))
    assertEquals(11, ticketScanner.yourTicketValueForField("row"))
    assertEquals(13, ticketScanner.yourTicketValueForField("seat"))
  }

  @Test fun `Part 2 - Input`() {
    val ticketScanner = TicketScanner(notes = readText("inputs/day16"))
    assertEquals(1289178686687, ticketScanner.departures())
  }
}
