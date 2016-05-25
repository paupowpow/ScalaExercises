object MuenzStueckelung {

  def main(args: Array[String]){
    println(muenzStueck(8, List(1,2,5,10,20,50,100)))
  }
  
  // Aufgabe 4
  // Anzahl der Möglichkeiten, den Betrag aus den entsprechenden Münzen zusammenzustellen
  def muenzStueck(betrag: Int, waehrung: List[Int]): Int = {
    if(betrag == 0) {
      1
    } else  if (waehrung == Nil) {
      0
    } else if (betrag < waehrung.head) {
      muenzStueck(betrag, waehrung.tail)
    } else {
      muenzStueck(betrag - waehrung.head, waehrung) +
      muenzStueck(betrag, waehrung.tail)
    }
  }
}