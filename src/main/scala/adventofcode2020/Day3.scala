package adventofcode2020

import scala.io.Source

object Day3 {

  val inputDataPath = "input-data/day-3.txt"
  val slopeCoordsPart1: (Int, Int) = (3, 1)
  val slopeCoordsPart2: Seq[(Int, Int)] = Seq((1, 1), slopeCoordsPart1, (5, 1), (7, 1), (1, 2))

  def main(args: Array[String]): Unit = {
    val tobogganMap = readMap(inputDataPath)
    val treesTotalPart1 = traverseTobogganPart1(tobogganMap, slopeCoordsPart1)
    println(s"Total number of traversed trees in Part 1: $treesTotalPart1")
    val treesTotalPart2 = traverseTobogganPart2(tobogganMap, slopeCoordsPart2)
    println(s"Total number of traversed trees in Part 2: $treesTotalPart2")

  }
  def readMap(path: String): List[String] = Source.fromResource(path).getLines().toList

  def traverseTobogganPart1(lines: Seq[String], slopeCoords: (Int, Int)): Int = {
    val height = lines.length
    val width = lines.head.length
    val (x, y) = slopeCoords

    (0 until height / y).map(i => lines(i * y)((i * x) % width)).count(_ == '#')
  }

  def traverseTobogganPart2(lines: List[String], slopeCoords: Seq[(Int, Int)]): Long =
    slopeCoords.map(slopeCoord => traverseTobogganPart1(lines, slopeCoord).toLong).product

}
