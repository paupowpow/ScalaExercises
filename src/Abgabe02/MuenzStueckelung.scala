object MuenzStueckelung {

  def main(args: Array[String]){
    val iteration = 0
    println(muenzStueck(8, List(1,2,5,10,20,50,100)))
  }
  
//  // Aufgabe 4
//  // Anzahl der Möglichkeiten, den Betrag aus den entsprechenden Münzen zusammenzustellen
//  def muenzStueck(betrag: Int, waehrung: List[Int], options: List[List[Int]], iteration: Int): Int = {
//    println("--------------------------------")
//    println("--------------------------------")
//    //options(iteration) = waehrung.head :: options(iteration)
//    //println(options)
//    println("iteration: " + iteration)
//    println("betrag: " + betrag)
//    if(betrag == 0) {
//
//      println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
//      println("A Result: " + 1)
//      println("A waehrung: " + waehrung)
//      1
//    } else  if (waehrung == Nil) {
//      println("B Result: " + 0)
//      println("B waehrung: " + waehrung)
//      0
//    } else if (betrag < waehrung.head) {
//      println("C waehrung.tail: " + waehrung.tail)
//      muenzStueck(betrag, waehrung.tail, options, iteration)
//    } else {
//      println("D waehrung.head: " + waehrung.head)
//      println("D waehrung.tail: " + waehrung.tail)
//      muenzStueck(betrag - waehrung.head, waehrung, options, iteration) +
//      muenzStueck(betrag, waehrung.tail, options, iteration+1)
//    }
//  }

  def muenzStueck(betrag: Int, waehrung: List[Int]): Int = {
    if (betrag == 0) {
      println(" X")
      1
    } else  if (waehrung == Nil) {
      println(" -")
      0
    } else if (betrag < waehrung.head) {
//      println("betrag: " + betrag + " waehrung.head: " + waehrung.head + "waehrung.tail.head" + (waehrung.tail).head +  C")
      muenzStueck(betrag, waehrung.tail)
    } else {
      println("betrag: " + betrag + " waehrung.head: " + waehrung.head + "waehrung.tail.head" + (waehrung.tail).head + " D")
      muenzStueck(betrag - waehrung.head, waehrung) +
        muenzStueck(betrag, waehrung.tail)
    }
  }

  def appendList(l: List[List[Int]], l2: List[Int]): List[List[Int]] = {
    if (l.isEmpty) {
      List(l2)
    } else {
      l.head :: appendList(l.tail, l2)
    }
  }
}

// Betrag abziehen, von Index