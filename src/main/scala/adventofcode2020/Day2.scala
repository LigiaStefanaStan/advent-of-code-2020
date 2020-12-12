package adventofcode2020

import scala.io.Source
import scala.util.matching.Regex

object Day2 {

  val inputDataPath = "input-data/day-2.txt"
  val regexLine: Regex = """(\d+)-(\d+) (\w): (\w+)""".r

  case class PasswordPolicy(min: Int, max: Int, letter: Char, password: String)

  def main(args: Array[String]): Unit = {
    val passwordsList: Seq[String] = readPasswords(inputDataPath)
    println(countValidPasswords(passwordsList))
  }

  def readPasswords(path: String): Seq[String] = Source.fromResource(path).getLines().toList

  def countValidPasswords(passwordsList: Seq[String]): Int =
    passwordsList.count {
      case regexLine(min, max, char, password) =>
        validatePassword(PasswordPolicy(min.toInt, max.toInt, char.head, password))
    }

  def validatePassword(passwordPolicy: PasswordPolicy): Boolean = {
    val passwordLength = passwordPolicy.password.count(_ == passwordPolicy.letter)
    passwordLength >= passwordPolicy.min && passwordLength <= passwordPolicy.max
  }

}
