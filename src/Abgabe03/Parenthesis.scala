object Parenthesis {
  
  def main(args: Array[String]){
    val stack = List('a','b','c','d','e','f')
    val string1 = "x(x(x))"
    val string2 = "(a)(b())"
    val string3 = "a("
    val string4 = ")x("
    
    println(balanced(string1.toList))
    println(balanced(string2.toList))
    println(balanced(string3.toList))
    println(balanced(string4.toList))
  }
  
  def push(l: List[Char], x: Char): List[Char] = {
    if(l.isEmpty){
      List(x)
    }
    else{
      x :: l
    }
  }
 
  def pop(l: List[Char]): List[Char] = {
    if(l.isEmpty){
      List()
    }
    else{
      l.tail
    }
  }
 
  def peek(l: List[Char]) : Char = {
    l.head
  }
  
//  def balanced(l: List[Char]): Boolean = {
//    def go(cs: List[Char], level: Int): Boolean = cs match {
//        case Nil => level == 0
//        case ')' :: _ if level < 1 => false
//        case ')' :: xs => go(xs, level - 1)
//        case '(' :: xs => go(xs, level + 1)
//        case _ :: xs => go(xs, level)
//    }
//    go(l, 0)
//  }
  
  def balanced(l: List[Char]): Boolean = {
    def check_balanced(chars: List[Char], open_parenthesis: Int): Boolean = {
      if (chars.isEmpty) {
        open_parenthesis == 0
      } else {
        if (chars.head == "(") {
          check_balanced(chars.tail, open_parenthesis+1)
        } else {
          if (chars.head == ")") {
            open_parenthesis > 0 &&
            check_balanced(chars.tail, open_parenthesis-1)
          } else {
            check_balanced(chars.tail, open_parenthesis)
          }
        }
      }
    }
    check_balanced(l, 0)
  }
 
}