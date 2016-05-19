object SimpleList {
  
  def main(args: Array[String]){
    val my_numbers : List[Int] = List(8,0,8,0,9,2,3,4)
    val my_fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
    val empty_list = List()
    val my_strings = "ack" :: ("pom" :: ("blergh"  :: ("bambam" :: ("ka-ching" :: Nil))))
    val dup_list = 2:: (2:: (3::(3::(1:: Nil))))
    val uniq_list = 1:: (3:: (5:: (7:: (11:: Nil))))
    val incomplete_list = "hi" :: ("i" :: ("am"  :: ("a" :: ("word" :: Nil))))
   
    //println(my_numbers)
    //println(length(my_numbers))
    //println(append(my_fruits, "mangoes"))
    //println(take(my_strings, 2))
    //println(drop(my_strings, 2))
    //println(uniq(dup_list))
    //println(dupall(uniq_list))
    //println(insertAt(incomplete_list, 3, "missing"))
    //println(removeAt(my_strings, 2))

    }
    
  // Aufgabe 1a
  def length (l: List[Int]): Int = {
    if (l.isEmpty) {
      0
    } else {
      1 + length(l.tail)
    }
  }
  
  def append(l: List[String], s: String): List[String] = {
    if (l.isEmpty) {
    	l
    } else {
      println("head: " + l.head + ", tail: " + l.tail + ", s: " + s)
      l.head :: append(l.tail, s)
    }
  }
  
  // Aufgabe 1b
  def take(l: List[String], n: Int): List[String] = {
    if ((n < 1) || (l.isEmpty)) {
      List()
    } else {
      l.head :: take(l.tail, n-1)
    }
  }
  
  // Aufgabe 1c
  def drop(l: List[String], n: Int): List[String] = {
    if ((n <= 1) || (l.isEmpty)) { 
    	l.tail
    } else {
      return drop(l.tail, n-1)
    }
  }
  
  // Aufgabe 1d
  def uniq(l: List[Int]): List[Int] = {
    if(l == Nil){
      Nil
    } else {
      if(l.tail.contains(l.head)){
        uniq(l.tail)
      }else{
        l.head :: uniq(l.tail)
      }
    }
  }
  
  //Aufgabe 1e
  def dupall (l: List[Int]): List[Int] = {
    if(l.tail == Nil) {
    	l.head:: (l.head:: Nil)
    } else {
    	l.head:: (l.head:: dupall(l.tail))     
    }
  }
  
  //Aufgabe 1f
  def insertAt (l: List[String], i: Int, x: String): List[String] = {
    if(i == 0) {
      x:: l
    } else {
      l.head:: insertAt(l.tail, i-1, x)
    }
  }
  
  //Aufgabe 1g
  def removeAt (l: List[String], i: Int): List[String] = {
    if(i == 0) {
      l.tail
    } else {
      l.head:: removeAt(l.tail, i-1)
    }
  }
  
}