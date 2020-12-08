package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day7Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      4,
      countBagsThatCanContain(
        rules = """
          light red bags contain 1 bright white bag, 2 muted yellow bags.
          dark orange bags contain 3 bright white bags, 4 muted yellow bags.
          bright white bags contain 1 shiny gold bag.
          muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
          shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
          dark olive bags contain 3 faded blue bags, 4 dotted black bags.
          vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
          faded blue bags contain no other bags.
          dotted black bags contain no other bags.
          """.trimIndent(),
        bag = Bag("shiny gold"),
      )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(
      226,
      countBagsThatCanContain(
        rules = readText("inputs/day7"),
        bag = Bag("shiny gold"),
      )
    )
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      32,
      totalContainedBags(
        rules = """
          light red bags contain 1 bright white bag, 2 muted yellow bags.
          dark orange bags contain 3 bright white bags, 4 muted yellow bags.
          bright white bags contain 1 shiny gold bag.
          muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
          shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
          dark olive bags contain 3 faded blue bags, 4 dotted black bags.
          vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
          faded blue bags contain no other bags.
          dotted black bags contain no other bags.
          """.trimIndent(),
        bag = Bag("shiny gold"),
      )
    )
    assertEquals(
      126,
      totalContainedBags(
        rules = """
          shiny gold bags contain 2 dark red bags.
          dark red bags contain 2 dark orange bags.
          dark orange bags contain 2 dark yellow bags.
          dark yellow bags contain 2 dark green bags.
          dark green bags contain 2 dark blue bags.
          dark blue bags contain 2 dark violet bags.
          dark violet bags contain no other bags.
          """.trimIndent(),
        bag = Bag("shiny gold"),
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(
      9569,
      totalContainedBags(
        rules = readText("inputs/day7"),
        bag = Bag("shiny gold"),
      )
    )
  }
}
