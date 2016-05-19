object SimpleList {
  def main(args: Array[String]){
// val list : List[String] = List("a","b","c")
//   append(List("a","b","c"), "d")
// println(append("apples" :: ("oranges" :: ("pears" :: Nil)), "carrots"))
// println(length(1:: (2 :: (3 :: Nil))))
    //println(take("apples" :: ("oranges" :: ("pears" :: Nil)), 2))
//    println(uniq(2:: (2:: (3::(3::(1:: Nil))))))
//    println(dupall(1::(2::(3::Nil))))
    val my_strings = "ack" :: ("pom" :: ("blergh" :: ("bambam" :: ("ka-ching" :: Nil))))
//    println(drop(my_strings, 2))
    val intList = List(1,2,3,4,5)//(1::(2::(3::Nil)))
    val secondList = List(5,6,7)
    //println(append(intList, 6))
    //println(length(intList))
    //println(take(intList, 2))
    // println(drop(intList, 2))
    //  println(uniq(2:: (2:: (3::(3::(1:: Nil))))))
//    println(dupall(1::(2::(3::Nil))))
    //println(insertAt(intList, 1, 1))
    println(removeAt(intList, 2))
    println(zaehlZeichen("esfunktioniert"))
  }
  
def append(l: List[Int], s: Int): List[Int] = {
  if(l == Nil){
     List(s)
 }
 else {
   println("head: " + l.head + ", tail: " + l.tail)
   l.head :: append(l.tail, s)
  }
 }

  def length(l: List[Int]): Int = {
    if (l == Nil){
      0
    }
    else{
      1 + length(l.tail)
    }
  }

 def take(l: List[Int], n: Int): List[Int] = {
   if (n > 0) {
     l.head :: take(l.tail, n-1)
   }
   else if(l == Nil){
     List(n)
   }
   else{
     List()
   }
 }
 
  def drop(l: List[Int], n: Int): List[Int] = {
    if ((n <= 1) || (l.isEmpty)) { 
    	l.tail
    } else {
      return drop(l.tail, n-1)
    }
  }

 def uniq(l: List[Int]): List[Int] = {
    if(l == Nil){
      //println("nil")
      Nil
    }
    else{
      if(l.tail.contains(l.head)){
        //println("tail contains head " + uniq(l.tail))
        uniq(l.tail)
      }
      else{
        //println("else:")
        l.head :: uniq(l.tail)
      }
      
    }
 }
 
 def dupall(l: List[Int]): List[Int] = {
   if(l == Nil){
      //println("nil")
      Nil
    }
   else{
     //println ("dupall l.tail: " + l.head :: l.head :: dupall(l.tail))
     l.head :: l.head :: dupall(l.tail)
   }
 }
 
def insertAt (l: List[Int], i: Int, x: Int): List[Int] = {
   if ((i > 2) && (! l.isEmpty)) {
     println("i: " + i)
     println("l: " + l)
     l.head :: insertAt(l.tail, i-1, x) //append(append(take(l,i-1),x),drop(l, i-1)) 
   }
   if(i == 2){
     println("i == 2")
     println("l: "  + l)
     println("l.tail" + l.tail)
     l.head :: x :: l.tail
   }
   if(i < 2){
     x :: l
   }
   else{
     List()
   }
 }

  def removeAt (l: List[Int], i: Int): List[Int] = {
    if(i == 0) {
      l.tail
    } else {
      l.head:: removeAt(l.tail, i-1)
    }
  }

  def zaehlZeichen(s: String): Map[String, Int] = {
    var gezaehlt = Map[String, Int]()
    for(letter <- s)  gezaehlt += (letter.toString -> (gezaehlt.getOrElse(letter.toString, 0) + 1))
    gezaehlt      
  }

 
}