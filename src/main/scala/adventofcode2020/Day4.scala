package adventofcode2020

import scala.io.Source

object Day4 {
  /**
   * Valid passwords have the following:
   * - byr (Birth Year)
   * - iyr (Issue Year)
   * - eyr (Expiration Year)
   * - hgt (Height)
   * - hcl (Hair Color)
   * - ecl (Eye Color)
   * - pid (Passport ID)
   * - cid (Country ID) --optional
   */

  private val inputDataPath = "input-data/day-4.txt"
  private val requiredFields = Seq("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  def main(args: Array[String]): Unit = {
    val passData = readPassportData(inputDataPath)
    val passportsArrayMaps: Array[Map[String, String]] = mapPassports(passData)
    println("Total number of valid passwords is: " + countValidPassports(passportsArrayMaps, isValidPassport))
  }

  def readPassportData(path: String): String = Source.fromResource(path).getLines().mkString("\n")

  def mapPassports(inputData: String): Array[Map[String, String]] = {
    inputData
      .split("\n\n")
      .map(_.split("[\\n\\s]"))
      .map{_.map { part =>
        part.split(":")
        match {
          case Array(key, value) => (key, value)
        }
      }.toMap[String, String]
      }
  }

  def isValidPassport(passports: Map[String, String]): Boolean = {
    requiredFields.forall(field => passports.contains(field))
  }

  def countValidPassports(passportsArray: Array[Map[String, String]], satisfyCondition: Map[String, String] => Boolean): Int = {
    passportsArray.count(passport => satisfyCondition(passport))
  }
}
