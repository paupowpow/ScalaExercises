package s0542425

object QuickSort {

  def main(args: Array[String]){
    val a = List(1,3,5,2,6,8,4,10)
    println(sort(a))
  }
  
  def sort(ls: List[Int]): List[Int] = {
    ls match {
      case Nil => Nil
      case pivot :: tail => {
        val (less, greater) = tail.partition(_ < pivot)
        sort(less) ::: pivot :: sort(greater)
      }
    }
  }

//  def quicksort (l: List[Int]): List[Int] = {
//
//  }
//
//  def filter (l: List[Int], bleibtdrin: Int ⇒ Boolean): List[Int] = {
//
//  }
//
//  def split (l: List[Int], x: Int): (List[Int], List[Int]) = {
//
//  }
//
//  def merge (l1: List[Int], l2: List[Int]): List[Int] = {
//
//  }

}