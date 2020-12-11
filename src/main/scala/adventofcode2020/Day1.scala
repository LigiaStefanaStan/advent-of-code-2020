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

    entries.flatMap { x =>
      entries.map { y =>
          if (x + y == entriesSum) {
            val multiplicationValue = x * y
            println(s"x = $x y = $y x * y = $multiplicationValue")
            multiplicationValue
          }
        }
      }.collect { case i: Int => i }.toList.distinct

  }

  //Part 2
  def findMatchesForThreeEntries(entries: Seq[Int], entriesSum: Int): Seq[Int] = {

    entries.flatMap { x =>
      entries.flatMap { y =>
        entries.map { z =>
          if (x + y + z == entriesSum) {
            val multiplicationValue = x * y * z
            println(s"x = $x y = $y z = $z  x * y * z = $multiplicationValue")
            multiplicationValue
          }
        }
      }
    }.collect { case i: Int => i }.toList.distinct

  }

}
