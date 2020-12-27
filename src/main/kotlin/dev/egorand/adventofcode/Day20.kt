package dev.egorand.adventofcode

import dev.egorand.adventofcode.JigsawTile.Border
import java.math.BigInteger
import java.math.BigInteger.ONE

/**
 * --- Day 20: Jurassic Jigsaw ---
 *
 * The high-speed train leaves the forest and quickly carries you south. You can even see a desert
 * in the distance! Since you have some spare time, you might as well see if there was anything
 * interesting in the image the Mythical Information Bureau satellite captured.
 *
 * After decoding the satellite messages, you discover that the data actually contains many small
 * images created by the satellite's camera array. The camera array consists of many cameras;
 * rather than produce a single square image, they produce many smaller square image tiles that
 * need to be reassembled back into a single image.
 *
 * Each camera in the camera array returns a single monochrome image tile with a random unique ID
 * number. The tiles (your puzzle input) arrived in a random order.
 *
 * Worse yet, the camera array appears to be malfunctioning: each image tile has been rotated and
 * flipped to a random orientation. Your first task is to reassemble the original image by
 * orienting the tiles so they fit together.
 *
 * To show how the tiles should be reassembled, each tile's image data includes a border that
 * should line up exactly with its adjacent tiles. All tiles have this border, and the border lines
 * up exactly when the tiles are both oriented correctly. Tiles at the edge of the image also have
 * this border, but the outermost edges won't line up with any other tiles.
 *
 * For example, suppose you have the following nine tiles:
 *
 * Tile 2311:
 * ..##.#..#.
 * ##..#.....
 * #...##..#.
 * ####.#...#
 * ##.##.###.
 * ##...#.###
 * .#.#.#..##
 * ..#....#..
 * ###...#.#.
 * ..###..###
 *
 * Tile 1951:
 * #.##...##.
 * #.####...#
 * .....#..##
 * #...######
 * .##.#....#
 * .###.#####
 * ###.##.##.
 * .###....#.
 * ..#.#..#.#
 * #...##.#..
 *
 * Tile 1171:
 * ####...##.
 * #..##.#..#
 * ##.#..#.#.
 * .###.####.
 * ..###.####
 * .##....##.
 * .#...####.
 * #.##.####.
 * ####..#...
 * .....##...
 *
 * Tile 1427:
 * ###.##.#..
 * .#..#.##..
 * .#.##.#..#
 * #.#.#.##.#
 * ....#...##
 * ...##..##.
 * ...#.#####
 * .#.####.#.
 * ..#..###.#
 * ..##.#..#.
 *
 * Tile 1489:
 * ##.#.#....
 * ..##...#..
 * .##..##...
 * ..#...#...
 * #####...#.
 * #..#.#.#.#
 * ...#.#.#..
 * ##.#...##.
 * ..##.##.##
 * ###.##.#..
 *
 * Tile 2473:
 * #....####.
 * #..#.##...
 * #.##..#...
 * ######.#.#
 * .#...#.#.#
 * .#########
 * .###.#..#.
 * ########.#
 * ##...##.#.
 * ..###.#.#.
 *
 * Tile 2971:
 * ..#.#....#
 * #...###...
 * #.#.###...
 * ##.##..#..
 * .#####..##
 * .#..####.#
 * #..#.#..#.
 * ..####.###
 * ..#.#.###.
 * ...#.#.#.#
 *
 * Tile 2729:
 * ...#.#.#.#
 * ####.#....
 * ..#.#.....
 * ....#..#.#
 * .##..##.#.
 * .#.####...
 * ####.#.#..
 * ##.####...
 * ##..#.##..
 * #.##...##.
 *
 * Tile 3079:
 * #.#.#####.
 * .#..######
 * ..#.......
 * ######....
 * ####.#..#.
 * .#...#.##.
 * #.#####.##
 * ..#.###...
 * ..#.......
 * ..#.###...
 *
 * By rotating, flipping, and rearranging them, you can find a square arrangement that causes all
 * adjacent borders to line up:
 *
 * #...##.#.. ..###..### #.#.#####.
 * ..#.#..#.# ###...#.#. .#..######
 * .###....#. ..#....#.. ..#.......
 * ###.##.##. .#.#.#..## ######....
 * .###.##### ##...#.### ####.#..#.
 * .##.#....# ##.##.###. .#...#.##.
 * #...###### ####.#...# #.#####.##
 * .....#..## #...##..#. ..#.###...
 * #.####...# ##..#..... ..#.......
 * #.##...##. ..##.#..#. ..#.###...
 *
 * #.##...##. ..##.#..#. ..#.###...
 * ##..#.##.. ..#..###.# ##.##....#
 * ##.####... .#.####.#. ..#.###..#
 * ####.#.#.. ...#.##### ###.#..###
 * .#.####... ...##..##. .######.##
 * .##..##.#. ....#...## #.#.#.#...
 * ....#..#.# #.#.#.##.# #.###.###.
 * ..#.#..... .#.##.#..# #.###.##..
 * ####.#.... .#..#.##.. .######...
 * ...#.#.#.# ###.##.#.. .##...####
 *
 * ...#.#.#.# ###.##.#.. .##...####
 * ..#.#.###. ..##.##.## #..#.##..#
 * ..####.### ##.#...##. .#.#..#.##
 * #..#.#..#. ...#.#.#.. .####.###.
 * .#..####.# #..#.#.#.# ####.###..
 * .#####..## #####...#. .##....##.
 * ##.##..#.. ..#...#... .####...#.
 * #.#.###... .##..##... .####.##.#
 * #...###... ..##...#.. ...#..####
 * ..#.#....# ##.#.#.... ...##.....
 *
 * For reference, the IDs of the above tiles are:
 *
 * 1951    2311    3079
 * 2729    1427    2473
 * 2971    1489    1171
 *
 * To check that you've assembled the image correctly, multiply the IDs of the four corner tiles
 * together. If you do this with the assembled tiles from the example above, you get 1951 * 3079 *
 * 2971 * 1171 = 20899048083289.
 *
 * Assemble the tiles into an image. What do you get if you multiply together the IDs of the four
 * corner tiles?
 *
 * --- Part Two ---
 *
 * Now, you're ready to check the image for sea monsters.
 *
 * The borders of each tile are not part of the actual image; start by removing them.
 *
 * In the example above, the tiles become:
 *
 * .#.#..#. ##...#.# #..#####
 * ###....# .#....#. .#......
 * ##.##.## #.#.#..# #####...
 * ###.#### #...#.## ###.#..#
 * ##.#.... #.##.### #...#.##
 * ...##### ###.#... .#####.#
 * ....#..# ...##..# .#.###..
 * .####... #..#.... .#......
 *
 * #..#.##. .#..###. #.##....
 * #.####.. #.####.# .#.###..
 * ###.#.#. ..#.#### ##.#..##
 * #.####.. ..##..## ######.#
 * ##..##.# ...#...# .#.#.#..
 * ...#..#. .#.#.##. .###.###
 * .#.#.... #.##.#.. .###.##.
 * ###.#... #..#.##. ######..
 *
 * .#.#.### .##.##.# ..#.##..
 * .####.## #.#...## #.#..#.#
 * ..#.#..# ..#.#.#. ####.###
 * #..####. ..#.#.#. ###.###.
 * #####..# ####...# ##....##
 * #.##..#. .#...#.. ####...#
 * .#.###.. ##..##.. ####.##.
 * ...###.. .##...#. ..#..###
 *
 * Remove the gaps to form the actual image:
 *
 * .#.#..#.##...#.##..#####
 * ###....#.#....#..#......
 * ##.##.###.#.#..######...
 * ###.#####...#.#####.#..#
 * ##.#....#.##.####...#.##
 * ...########.#....#####.#
 * ....#..#...##..#.#.###..
 * .####...#..#.....#......
 * #..#.##..#..###.#.##....
 * #.####..#.####.#.#.###..
 * ###.#.#...#.######.#..##
 * #.####....##..########.#
 * ##..##.#...#...#.#.#.#..
 * ...#..#..#.#.##..###.###
 * .#.#....#.##.#...###.##.
 * ###.#...#..#.##.######..
 * .#.#.###.##.##.#..#.##..
 * .####.###.#...###.#..#.#
 * ..#.#..#..#.#.#.####.###
 * #..####...#.#.#.###.###.
 * #####..#####...###....##
 * #.##..#..#...#..####...#
 * .#.###..##..##..####.##.
 * ...###...##...#...#..###
 *
 * Now, you're ready to search for sea monsters! Because your image is monochrome, a sea monster
 * will look like this:
 *
 * #
 * #    ##    ##    ###
 * #  #  #  #  #  #
 *
 * When looking for this pattern in the image, the spaces can be anything; only the # need to
 * match. Also, you might need to rotate or flip your image before it's oriented correctly to find
 * sea monsters. In the above image, after flipping and rotating it to the appropriate orientation,
 * there are two sea monsters (marked with O):
 *
 * .####...#####..#...###..
 * #####..#..#.#.####..#.#.
 * .#.#...#.###...#.##.O#..
 * #.O.##.OO#.#.OO.##.OOO##
 * ..#O.#O#.O##O..O.#O##.##
 * ...#.#..##.##...#..#..##
 * #.##.#..#.#..#..##.#.#..
 * .###.##.....#...###.#...
 * #.####.#.#....##.#..#.#.
 * ##...#..#....#..#...####
 * ..#.##...###..#.#####..#
 * ....#.##.#.#####....#...
 * ..##.##.###.....#.##..#.
 * #...#...###..####....##.
 * .#.##...#.##.#.#.###...#
 * #.###.#..####...##..#...
 * #.###...#.##...#.##O###.
 * .O##.#OO.###OO##..OOO##.
 * ..O#.O..O..O.#O##O##.###
 * #.#..##.########..#..##.
 * #.#####..#.#...##..#....
 * #....##..#.#########..##
 * #...#.....#..##...###.##
 * #..###....##.#...##.##.#
 *
 * Determine how rough the waters are in the sea monsters' habitat by counting the number of # that
 * are not part of a sea monster. In the above example, the habitat's water roughness is 273.
 *
 * How many # are not part of a sea monster?
 */

fun multiplyCornerTileIds(jigsaw: String): BigInteger {
  val tileConfigurations = jigsaw.split("\n\n")
  val tiles = tileConfigurations.map(JigsawTile.Companion::invoke)
  val tilesByBorder = buildMap<Border, MutableSet<JigsawTile>> {
    for (tile in tiles) {
      for (border in tile.possibleBorders) {
        getOrPut(border, ::mutableSetOf) += tile
      }
    }
  }
  val privateBorderCounts = buildMap<JigsawTile, Int> {
    for (tiles in tilesByBorder.values) {
      if (tiles.size == 1) {
        val tile = tiles.single()
        put(tile, getOrDefault(tile, 0) + 1)
      }
    }
  }
  val cornerTiles = privateBorderCounts.filter { (_, borderCount) -> borderCount == 4 }
  return cornerTiles.keys.fold(ONE) { acc, tile -> acc * tile.id.toBigInteger() }
}

class JigsawTile(val id: Int, pixels: Array<CharArray>) {
  val possibleBorders = Array(8) { index ->
    val leftBorder = CharArray(pixels.size) { index -> pixels[index].first() }
    val topBorder = pixels.first()
    val rightBorder = CharArray(pixels.size) { index -> pixels[index].last() }
    val bottomBorder = pixels.last()
    when (index) {
      0 -> Border(leftBorder)
      1 -> Border(leftBorder.reversedArray())
      2 -> Border(topBorder)
      3 -> Border(topBorder.reversedArray())
      4 -> Border(rightBorder)
      5 -> Border(rightBorder.reversedArray())
      6 -> Border(bottomBorder)
      7 -> Border(bottomBorder.reversedArray())
      else -> throw AssertionError()
    }
  }

  override fun equals(other: Any?): Boolean = other is JigsawTile && other.id == id

  override fun hashCode(): Int = id

  override fun toString(): String = "Tile $id"

  companion object {
    private val ID_REGEX = Regex("^Tile (\\d+):$")

    operator fun invoke(configuration: String): JigsawTile {
      val lines = configuration.lines()
      val (id) = lines[0].parse(ID_REGEX)
      val pixels = Array(lines.size - 1) { index -> lines[index + 1].toCharArray() }
      return JigsawTile(id.toInt(), pixels)
    }
  }

  class Border(val pixels: CharArray) {
    private val hashCode = Integer.parseInt(buildString {
      for (pixel in pixels) append(if (pixel == '#') 1 else 0)
    }, 2)

    override fun equals(other: Any?): Boolean {
      return other is Border && other.pixels.contentEquals(pixels)
    }

    override fun hashCode(): Int = hashCode

    override fun toString(): String = pixels.concatToString()
  }
}
