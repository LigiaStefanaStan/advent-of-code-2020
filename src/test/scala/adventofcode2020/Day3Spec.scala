package adventofcode2020

import Day3._
import org.scalatest.{FunSuite, Matchers}

class Day3Spec extends FunSuite with Matchers {

  val testPath = "test-data/test-day-3.txt"
  val testCoords1: (Int, Int) = (3, 1)
  val testCoords2 = Seq((1, 1), (1, 2))

  test("count the number of trees met while traversing the toboggan for coordinates (3, 1)") {
    traverseTobogganPart1(readMap(testPath), testCoords1) shouldBe 7
  }

  test("get the number of trees met while traversing the toboggan per pair of coordinates and multiply them") {
    traverseTobogganPart2(readMap(testPath), testCoords2) shouldBe 4
  }

}
