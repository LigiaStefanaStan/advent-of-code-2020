package adventofcode2020

import scala.io.Source

object Day1 {

  val inputDataPath = "input-data/day-1.txt"
  val entriesSum = 2020

  def main(args: Array[String]): Unit = {
    val reportEntries = readExpenseReport(inputDataPath)
    println("Part 1 ---------------------------------")
    findEntryMatches(reportEntries, entriesSum)
    println("Part 2 ---------------------------------")
    findMatchesForThreeEntries(reportEntries, entriesSum)
  }

  def readExpenseReport(path: String): Seq[Int] = Source.fromResource(path).getLines().toSeq.map(_.toInt)

  //Part 1
  def findEntryMatches(entries: Seq[Int], entriesSum: Int): Seq[Int] = {
    for {
      x <- entries
      y <- entries
      if x + y == entriesSum
    } yield {
      println(s"x = $x y = $y  x * y = " + x * y)
      x * y
    }
  }

  //Part 2
  def findMatchesForThreeEntries(entries: Seq[Int], entriesSum: Int): Seq[Int] = {
    (for {
      x <- entries
      y <- entries
      z <- entries
      if x + y + z == entriesSum
    } yield {
      println(s"x = $x y = $y  z = $z  x * y * z = " + x * y * z)
      x * y * z
    }).distinct
  }

}
