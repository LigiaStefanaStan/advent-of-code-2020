package adventofcode2020

import Day2._
import org.scalatest.{FunSuite, Matchers}

class Day2Spec extends FunSuite with Matchers {

  val testPath = "test-data/test-day-2.txt"

  test("read entries from file") {
    readPasswords(testPath) shouldBe Seq("6-9 r: richard", "5-6 p: phillip", "1-2 a: ligia", "4-5 b: stuart")
  }

  test("count the valid passwords") {
    countValidPasswords(readPasswords(testPath)) shouldBe 1
  }

}
