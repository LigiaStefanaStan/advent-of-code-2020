package adventofcode2020

import scala.io.Source

object Day4 {

  private val inputDataPath = "input-data/day-4.txt"
  private val requiredFields = Seq("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  def main(args: Array[String]): Unit = {
    val passData = readPassportData(inputDataPath)
    val passportsArrayMaps: Array[Map[String, String]] = mapPassports(passData)
    println("Total number of valid passwords for part 1 is: " + countValidPassports(passportsArrayMaps, isValidPassport))
    println("Total number of valid passwords for part 2 is: " + countValidPassports(passportsArrayMaps, isValidPassportBasedOnRules))
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

  def isValidPassportBasedOnRules(passports: Map[String, String]): Boolean = {
    isValidPassport(passports) && passports.forall {
      case (key, value) => key match {
        case "byr" => 1920 <= value.toInt && value.toInt <= 2002
        case "iyr" => 2010 <= value.toInt && value.toInt <= 2020
        case "eyr" => 2020 <= value.toInt && value.toInt <= 2030
        case "hgt" =>
          val pattern = """(\d+)(cm|in)""".r
          value match {
            case pattern(height, unit) => unit match {
              case "cm" => 150 <= height.toInt && height.toInt <= 193
              case "in" => 59 <= height.toInt && height.toInt <= 76
              case _ => false
            }
            case _ => false
          }
        case "hcl" => value.matches("#[0-9a-f]{6}")
        case "ecl" => value.matches("amb|blu|brn|gry|grn|hzl|oth")
        case "pid" => value.matches("[0-9]{9}")
        case "cid" => true
        case _ => false
      }
    }
  }

  def countValidPassports(passportsArray: Array[Map[String, String]], satisfyCondition: Map[String, String] => Boolean): Int = {
    passportsArray.count(passport => satisfyCondition(passport))
  }
}
