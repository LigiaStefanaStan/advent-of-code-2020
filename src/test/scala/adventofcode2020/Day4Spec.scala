package adventofcode2020

import adventofcode2020.Day4._
import org.scalatest.{FunSuite, Matchers}

class Day4Spec extends FunSuite with Matchers {

  private val testPath = "test-data/test-day-4.txt"
  private val testData = readPassportData(testPath)

  test("count the number of valid passports") {
    countValidPassports(mapPassports(testData), isValidPassport) shouldBe 2
  }

}
