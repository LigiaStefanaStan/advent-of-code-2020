package adventofcode2020

import scala.io.Source
import scala.util.matching.Regex

object Day2 {

  val inputDataPath = "input-data/day-2.txt"
  val regexLine: Regex = """(\d+)-(\d+) (\w): (\w+)""".r

  case class PasswordPolicy(min: Int, max: Int, letter: Char, password: String)

  def main(args: Array[String]): Unit = {
    val passwordsList: Seq[String] = readPasswords(inputDataPath)

    println("Part 1 ---------------------------------")
    println(countValidPasswordsPart1(passwordsList))

    println("Part 2 ---------------------------------")
    println(countValidPasswordsPart2(passwordsList))
  }

  def readPasswords(path: String): Seq[String] = Source.fromResource(path).getLines().toList

  //Part 1
  def countValidPasswordsPart1(passwordsList: Seq[String]): Int =
    passwordsList.count {
      case regexLine(min, max, char, password) =>
        validatePasswordPart1(PasswordPolicy(min.toInt, max.toInt, char.head, password))
    }

  def validatePasswordPart1(passwordPolicy: PasswordPolicy): Boolean = {
    val passwordLength = passwordPolicy.password.count(_ == passwordPolicy.letter)
    passwordLength >= passwordPolicy.min && passwordLength <= passwordPolicy.max
  }

  //Part 2
  def countValidPasswordsPart2(passwordsList: Seq[String]): Int =
    passwordsList.count {
      case regexLine(min, max, char, password) =>
        validatePasswordPart2(PasswordPolicy(min.toInt, max.toInt, char.head, password))
    }

  def validatePasswordPart2(passwordPolicy: PasswordPolicy): Boolean = {
    val minPasswordChar = passwordPolicy.password.charAt(passwordPolicy.min - 1)
    val maxPasswordChar = passwordPolicy.password.charAt(passwordPolicy.max - 1)

    minPasswordChar == passwordPolicy.letter && maxPasswordChar != passwordPolicy.letter ||
      minPasswordChar != passwordPolicy.letter && maxPasswordChar == passwordPolicy.letter
  }

}
