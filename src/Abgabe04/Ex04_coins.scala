package de.htw.scala.abgabe02

object Ex04_coins extends App {
  
  def muenzStueckl(werte: List[Int], betrag: Int): Int = {
    val l = muenzPermutationen(werte, betrag, List())
    println("muenzPermutationen:\t\t" + l)
    l.length
  }

  def muenzPermutationen(werte: List[Int], betrag: Int, pl: List[Int]): List[List[Int]] = {
    if (betrag == 0) Nil
    else {
      werte match {
        case Nil                              => Nil
        case head :: tail if (betrag == head) => List(head :: pl) ::: muenzPermutationen(tail, betrag, pl)
        case head :: tail if (betrag >  head) => muenzPermutationen(werte, betrag - head, head :: pl) ::: muenzPermutationen(tail, betrag, pl)
        case _    :: tail                     => muenzPermutationen(tail, betrag, pl)
      }
    }
  }

  val euroCoins = List(1, 2, 5, 10, 20, 50, 100, 500, 1000)
  println("euroCoins:\t\t\t" + euroCoins + "\n")
  var i = 0
  for (i <- 0 to 7) {
    println("muenzStueckl(euroCoins, " + i + "):\t" + muenzStueckl(euroCoins, i) + "\n")
  }
  
}