
object Uebung02 {
  
  def main(args: Array[String]){
    val l = List(10,20,50,100,200)
    //println(wechsel(betrag, 10))
    //println(betrag(l, 0, 15))
    //println(walk(l, l.head))
    //println(combine(l,l))
    //println("muenzStueckl " + muenzStueckl(List(1,2,5,10,20,50,100),1))
    val a = List(1,3,5,2,6,8,4,10)
    //println(split(a, 5))
    println(sort(a))
  }
  //Hilfsfunktion
   def count(betrag: Int, werte: List[Int], anzahl: Int): Int ={
      if(werte.isEmpty || betrag < 0){
        0
      }
      else if (betrag == 0){
          betrag + 1
        }
        else{
          //println(zaehlStueckl(betrag, werte.tail, betrag) + zaehlStueckl(betrag - werte.head, werte, betrag))
          println("betrag: " + betrag + (betrag - werte.head))
          println("anzahl: " + betrag + betrag)
          count(betrag, werte.tail, betrag) + count(betrag - werte.head, werte, betrag)
        }
     }
      
  def muenzStueckl(werte: List[Int], betrag: Int) : Int = {

    //println("zaehlStueckl")
    count(betrag, werte, 0)
  }
  
//  def quicksort(l: List[Int]) : List[Int] = {
//    
//  }
  
//  def insert(value: Int, l: List[Int]) : List[Int] = l match{
//      case h::t if(value > h) => h::insert(value,t)
//      case _ => value::l
//    }
  
  
  //aufteilen der Liste in zwei Listen, deren Elemtente groesser / kleiner  x sind
//  def split(l: List[Int], x: Int): (List[Int], List[Int]) = {
//
//    tuple((l, Nil),x)
////    val tuple = (List(), List())
////    if(l == Nil){
////      tuple
////    }
////    else if(l.head < x){
////      //split(l.tail, x) 
////      println(l.head :: tuple._1)
////      split(l.tail, x)
////    }
////    else if(l.head >= x){
////      split(l.head :: tuple._2, x)
////      //(tuple._1, l.head :: tuple._2)
////    }
////    else{
////      (List(), List())
////    }
//  }
  def sort(ls: List[Int]): List[Int] = {
   ls match {
    case Nil => Nil
    case pivot :: tail => {
      val (less, greater) = tail.partition(_ < pivot)
      sort(less) ::: pivot :: sort(greater)
      }
    }
  }
 }