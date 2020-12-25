package dev.egorand.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class Day24Test {
  @Test fun `Part 1 - Examples`() {
    assertEquals(Tile(6, 0), findTile("esenee"))
    assertEquals(Tile(1, 1), findTile("esew"))
    assertEquals(Tile(0, 0), findTile("nwwswee"))

    assertEquals(
      10,
      flipTiles(
        """
        sesenwnenenewseeswwswswwnenewsewsw
        neeenesenwnwwswnenewnwwsewnenwseswesw
        seswneswswsenwwnwse
        nwnwneseeswswnenewneswwnewseswneseene
        swweswneswnenwsewnwneneseenw
        eesenwseswswnenwswnwnwsewwnwsene
        sewnenenenesenwsewnenwwwse
        wenwwweseeeweswwwnwwe
        wsweesenenewnwwnwsenewsenwwsesesenwne
        neeswseenwwswnwswswnw
        nenwswwsewswnenenewsenwsenwnesesenew
        enewnwewneswsewnwswenweswnenwsenwsw
        sweneswneswneneenwnewenewwneswswnese
        swwesenesewenwneswnwwneseswwne
        enesenwswwswneneswsenwnewswseenwsese
        wnwnesenesenenwwnenwsewesewsesesew
        nenewswnwewswnenesenwnesewesw
        eneswnwswnwsenenwnwnwwseeswneewsenese
        neswnwewnwnwseenwseesewsenwsweewe
        wseweeenwnesenwwwswnew  
        """.trimIndent()
      ).countBlackTiles()
    )
  }

  @Test fun `Part 1 - Input`() {
    assertEquals(312, flipTiles(readText("inputs/day24")).countBlackTiles())
  }

  @Test fun `Part 2 - Examples`() {
    val tiles = flipTiles(
      """
        sesenwnenenewseeswwswswwnenewsewsw
        neeenesenwnwwswnenewnwwsewnenwseswesw
        seswneswswsenwwnwse
        nwnwneseeswswnenewneswwnewseswneseene
        swweswneswnenwsewnwneneseenw
        eesenwseswswnenwswnwnwsewwnwsene
        sewnenenenesenwsewnenwwwse
        wenwwweseeeweswwwnwwe
        wsweesenenewnwwnwsenewsenwwsesesenwne
        neeswseenwwswnwswswnw
        nenwswwsewswnenenewsenwsenwnesesenew
        enewnwewneswsewnwswenweswnenwsenwsw
        sweneswneswneneenwnewenewwneswswnese
        swwesenesewenwneswnwwneseswwne
        enesenwswwswneneswsenwnewswseenwsese
        wnwnesenesenenwwnenwsewesewsesesew
        nenewswnwewswnenesenwnesewesw
        eneswnwswnwsenenwnwnwwseeswneewsenese
        neswnwewnwnwseenwseesewsenwsweewe
        wseweeenwnesenwwwswnew  
        """.trimIndent()
    )
    assertEquals(10, simulateLivingArt(tiles, days = 0).countBlackTiles())
    assertEquals(15, simulateLivingArt(tiles, days = 1).countBlackTiles())
    assertEquals(12, simulateLivingArt(tiles, days = 2).countBlackTiles())
    assertEquals(25, simulateLivingArt(tiles, days = 3).countBlackTiles())
    assertEquals(14, simulateLivingArt(tiles, days = 4).countBlackTiles())
    assertEquals(23, simulateLivingArt(tiles, days = 5).countBlackTiles())
    assertEquals(28, simulateLivingArt(tiles, days = 6).countBlackTiles())
    assertEquals(41, simulateLivingArt(tiles, days = 7).countBlackTiles())
    assertEquals(37, simulateLivingArt(tiles, days = 8).countBlackTiles())
    assertEquals(49, simulateLivingArt(tiles, days = 9).countBlackTiles())
    assertEquals(37, simulateLivingArt(tiles, days = 10).countBlackTiles())

    assertEquals(132, simulateLivingArt(tiles, days = 20).countBlackTiles())
    assertEquals(259, simulateLivingArt(tiles, days = 30).countBlackTiles())
    assertEquals(406, simulateLivingArt(tiles, days = 40).countBlackTiles())
    assertEquals(566, simulateLivingArt(tiles, days = 50).countBlackTiles())
    assertEquals(788, simulateLivingArt(tiles, days = 60).countBlackTiles())
    assertEquals(1106, simulateLivingArt(tiles, days = 70).countBlackTiles())
    assertEquals(1373, simulateLivingArt(tiles, days = 80).countBlackTiles())
    assertEquals(1844, simulateLivingArt(tiles, days = 90).countBlackTiles())
    assertEquals(2208, simulateLivingArt(tiles, days = 100).countBlackTiles())
  }

  @Test fun `Part 2 - Input`() {
    val tiles = flipTiles(readText("inputs/day24"))
    assertEquals(3733, simulateLivingArt(tiles, days = 100).countBlackTiles())
  }
}