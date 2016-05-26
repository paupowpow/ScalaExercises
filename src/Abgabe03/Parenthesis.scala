object Parenthesis {

  def main(args: Array[String]){
    val list = List('a','b','c','d','e','f')
    val string = ")x("
    println(balanced(string.toList))
  }

  def push(l: List[Char], x: Char): List[Char] = {
    if(l == Nil){
      println(List(x))
      List(x)
    }
    else {
      println("head: " + l.head + ", tail: " + l.tail)
      l.head :: push(l.tail, x)
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

  def balanced(l: List[Char]): Boolean = {
    val stack = List[Char]()
    check(l, stack)
  }

  def check(l: List[Char], stack: List[Char]): Boolean = {
    if(l.isEmpty){
      stack.isEmpty
    }
    else if(l.head =='('){
      println("stack: " + stack)
      println("l.head: " + l.head)
      check(l.tail, push(stack, l.head))
    }
    else if(l.head == ')' && stack.isEmpty){
      false
    }
    else if(l.head == ')' && !stack.isEmpty){
      check(l.tail, pop(stack))
    }
    else{
      check(l.tail, stack)
    }
  }
}