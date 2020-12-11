package adventofcode2020

import adventofcode2020.Day1._
import org.scalatest._

class Day1Spec extends FunSuite with Matchers {

  val testPath = "test-data/test-day-1.txt"
  val entriesSum = 10

  test("read entries from file") {
    readExpenseReport(testPath) shouldBe Seq(1, 2, 3, 4, 5)
  }

  test("find the entries that match the sum and multiply them") {
    findEntryMatches(readExpenseReport(testPath), entriesSum) shouldBe Seq(25)
  }

}

