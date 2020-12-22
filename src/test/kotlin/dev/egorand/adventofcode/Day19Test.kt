package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day19Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(
      2,
      countMatchesForRule(
        0,
        """
        0: 1 2
        1: "a"
        2: 1 3 | 3 1
        3: "b"
        
        aab
        aba
        abc
        cba
        aaba
        aabc
        
        aa
        z
        """.trimIndent()
      )
    )
    assertEquals(
      8,
      countMatchesForRule(
        0,
        """
        0: 4 1 5
        1: 2 3 | 3 2
        2: 4 4 | 5 5
        3: 4 5 | 5 4
        4: "a"
        5: "b"
        
        aaaabb
        aaabab
        abbabb
        abbbab
        aabaab
        aabbbb
        abaaab
        ababbb
        """.trimIndent()
      )
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(118, countMatchesForRule(0, readText("inputs/day19")))
  }

  @Test fun `Part 2 - Examples`() {
    assertEquals(
      6,
      countMatchesForRule(
        0,
        """
        42: "a"
        31: "b"
        0: 8 11
        8: 42 | 42 8
        11: 42 31 | 42 11 31
        
        aab
        aaab
        aaaab
        aaabb
        aaaabbb
        aaaabb
        """.trimIndent()
      )
    )
    assertEquals(
      3,
      countMatchesForRule(
        0,
        """
        42: 9 14 | 10 1
        9: 14 27 | 1 26
        10: 23 14 | 28 1
        1: "a"
        11: 42 31
        5: 1 14 | 15 1
        19: 14 1 | 14 14
        12: 24 14 | 19 1
        16: 15 1 | 14 14
        31: 14 17 | 1 13
        6: 14 14 | 1 14
        2: 1 24 | 14 4
        0: 8 11
        13: 14 3 | 1 12
        15: 1 | 14
        17: 14 2 | 1 7
        23: 25 1 | 22 14
        28: 16 1
        4: 1 1
        20: 14 14 | 1 15
        3: 5 14 | 16 1
        27: 1 6 | 14 18
        14: "b"
        21: 14 1 | 1 14
        25: 1 1 | 1 14
        22: 14 14
        8: 42
        26: 14 22 | 1 20
        18: 15 15
        7: 14 5 | 1 21
        24: 14 1
        
        abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa
        bbabbbbaabaabba
        babbbbaabbbbbabbbbbbaabaaabaaa
        aaabbbbbbaaaabaababaabababbabaaabbababababaaa
        bbbbbbbaaaabbbbaaabbabaaa
        bbbababbbbaaaaaaaabbababaaababaabab
        ababaaaaaabaaab
        ababaaaaabbbaba
        baabbaaaabbaaaababbaababb
        abbbbabbbbaaaababbbbbbaaaababb
        aaaaabbaabaaaaababaa
        aaaabbaaaabbaaa
        aaaabbaabbaaaaaaabbbabbbaaabbaabaaa
        babaaabbbaaabaababbaabababaaab
        aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba
        """.trimIndent()
      )
    )
    assertEquals(
      12,
      countMatchesForRule(
        0,
        """
        42: 9 14 | 10 1
        9: 14 27 | 1 26
        10: 23 14 | 28 1
        1: "a"
        5: 1 14 | 15 1
        19: 14 1 | 14 14
        12: 24 14 | 19 1
        16: 15 1 | 14 14
        31: 14 17 | 1 13
        6: 14 14 | 1 14
        2: 1 24 | 14 4
        0: 8 11
        13: 14 3 | 1 12
        15: 1 | 14
        17: 14 2 | 1 7
        23: 25 1 | 22 14
        28: 16 1
        4: 1 1
        20: 14 14 | 1 15
        3: 5 14 | 16 1
        27: 1 6 | 14 18
        14: "b"
        21: 14 1 | 1 14
        25: 1 1 | 1 14
        22: 14 14
        26: 14 22 | 1 20
        18: 15 15
        7: 14 5 | 1 21
        24: 14 1
        8: 42 | 42 8
        11: 42 31 | 42 11 31
        
        abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa
        bbabbbbaabaabba
        babbbbaabbbbbabbbbbbaabaaabaaa
        aaabbbbbbaaaabaababaabababbabaaabbababababaaa
        bbbbbbbaaaabbbbaaabbabaaa
        bbbababbbbaaaaaaaabbababaaababaabab
        ababaaaaaabaaab
        ababaaaaabbbaba
        baabbaaaabbaaaababbaababb
        abbbbabbbbaaaababbbbbbaaaababb
        aaaaabbaabaaaaababaa
        aaaabbaaaabbaaa
        aaaabbaabbaaaaaaabbbabbbaaabbaabaaa
        babaaabbbaaabaababbaabababaaab
        aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba
        """.trimIndent()
      )
    )
  }

  @Test fun `Part 2 - Input`() {
    assertEquals(246, countMatchesForRule(0, readText("inputs/day19-part2")))
  }
}
