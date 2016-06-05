//package Abgabe04
//
///**
//  * Created by paulahaertel on 31.05.16.
//  */
//object Labyrinth {
//
//  case class Cell (free: Boolean, start: Boolean) {
//
//  }
//
//  case class Position (x: Int, y: Int) {
//    def north = Position(x, y-1)
//    def east = Position(x+1, y)
//    def south = Position(x, y+1)
//    def west = Position(x-1, y)
//
//    override def toString = "(" + x + "|" + y + ")"
//
//  }
//
//  type Labyrinth = Seq[Seq(Cell]
//
//  def readLabyrinth (fu: String): Labyrinth = {
//    try {
//      (for zeile <- io.Source.fromFile(laby3.txt, "UTF-8").getLines.toList)
//        yield
//          for ()
//    }
//  }
//
//}
