package adventofcode2020

import scala.io.Source
import scala.util.matching.Regex

object Day2 {

  val inputDataPath = "input-data/day-2.txt"
  val regexLine: Regex = """(\d+)-(\d+) (\w): (\w+)""".r

  case class PasswordPolicy(min: Int, max: Int, letter: Char, password: String)

  def main(args: Array[String]): Unit = {
    val passwordsList: Seq[String] = readPasswords(inputDataPath)

    println("Part 1: " + countValidPasswordsPart(passwordsList, isValidPasswordPart1))
    println("Part 2: " + countValidPasswordsPart(passwordsList, isValidPasswordPart2))
  }

  def readPasswords(path: String): Seq[String] = Source.fromResource(path).getLines().toList

  def countValidPasswordsPart(passwordsList: Seq[String], satisfyPolicy: PasswordPolicy => Boolean): Int =
    passwordsList.count {
      case regexLine(min, max, char, password) =>
        satisfyPolicy(PasswordPolicy(min.toInt, max.toInt, char.head, password))
    }

  def isValidPasswordPart1(passwordPolicy: PasswordPolicy): Boolean = {
    val passwordLength = passwordPolicy.password.count(_ == passwordPolicy.letter)
    passwordLength >= passwordPolicy.min && passwordLength <= passwordPolicy.max
  }

  def isValidPasswordPart2(passwordPolicy: PasswordPolicy): Boolean = {
    val minPasswordChar = passwordPolicy.password.charAt(passwordPolicy.min - 1)
    val maxPasswordChar = passwordPolicy.password.charAt(passwordPolicy.max - 1)

    minPasswordChar == passwordPolicy.letter && maxPasswordChar != passwordPolicy.letter ||
      minPasswordChar != passwordPolicy.letter && maxPasswordChar == passwordPolicy.letter
  }

}
