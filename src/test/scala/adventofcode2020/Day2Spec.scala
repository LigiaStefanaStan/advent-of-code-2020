package adventofcode2020

import Day2._
import org.scalatest.{FunSuite, Matchers}

class Day2Spec extends FunSuite with Matchers {

  val testPath = "test-data/test-day-2.txt"

  test("read entries from file") {
    readPasswords(testPath) shouldBe Seq("1-6 r: richard", "5-6 p: phillip", "1-2 i: ligia", "2-5 b: stuart")
  }

  test("count the valid passwords for first policy rule") {
    countValidPasswords(readPasswords(testPath), isValidPasswordPart1) shouldBe 2
  }

  test("count the valid passwords for second policy rule") {
    countValidPasswords(readPasswords(testPath), isValidPasswordPart2) shouldBe 1
  }

}
