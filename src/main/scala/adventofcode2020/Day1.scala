package adventofcode2020

import scala.io.Source

object Day1 {

  val inputDataPath = "input-data/day-1.txt"
  val entriesSum = 2020

  def main(args: Array[String]): Unit = {

    val reportEntries = readExpenseReport(inputDataPath)
    findEntryMatches(reportEntries, entriesSum)
    //Part 1 - puzzle answer is 567171

  }

  def readExpenseReport(path: String): Seq[Int] = Source.fromResource(path).getLines().toSeq.map(_.toInt)

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

}
