package adventofcode2020

import adventofcode2020.Day1._
import org.scalatest._

class Day1Spec extends FunSuite with Matchers {

  val testPath = "test-data/test-day-1.txt"

  test("read entries from file") {
    readExpenseReport(testPath) shouldBe Seq(1, 2, 3, 4, 5)
  }

  test("find the product of two entries that match the sum") {
    findEntryMatches(readExpenseReport(testPath), 10) shouldBe Seq(25)
  }

  test("find the product of three entries that match the sum") {
    findMatchesForThreeEntries(readExpenseReport(testPath), 8) shouldBe Seq(10, 12, 16, 18)
  }

}

