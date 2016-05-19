package s0542425

object ZaehlZeichen {  
  
  def main(args: Array[String]){   
    val my_string = "abccddddd"
    println(zaehlZeichen(my_string))
  }
   
  //Aufgabe 2
  def zaehlZeichen (s: String): Map[Char, Int] = {
    var gezaehlt = Map[Char, Int]()
    for(ch <- s) gezaehlt += (ch -> (gezaehlt.getOrElse(ch, 0) + 1))
    gezaehlt
  }
  
}