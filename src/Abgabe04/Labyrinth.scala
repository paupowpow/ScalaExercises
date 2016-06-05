import scala.io.Source

object Labyrinth {
  def main(args: Array[String]){
    Source
      .fromFile("/Users/paulahaertel/Programmierung/ScalaExercises/src/Abgabe04/laby3.txt")
      .getLines
      .foreach { line =>
        //do stuff with line like
        println(line)
      }


    val lab = liesLab("laby3.txt")
    val start = findStart(lab)
    println(append(List(), start))


    depthFirst(start, lab, List[Pos]())

  }

  case class Zelle(frei: Boolean, start: Boolean)

  case class Pos(x: Int, y: Int){
    def nord = Pos(x, y-1)
    def ost = Pos(x+1, y)
    def sued = Pos(x, y+1)
    def west = Pos(x-1, y)
    override def toString = "(" + x + ", " + y + ")"
  }

  type Labyrinth = Seq[Seq[Zelle]]

  def liesLab(fu: String): Labyrinth = {
    try{
      (for(zeile <- Source
        .fromFile("/Users/paulahaertel/Programmierung/ScalaExercises/src/Abgabe04/laby3.txt", "UTF-8").getLines.toList)
        yield
          for(c <- zeile) yield Zelle(c == ' ', c == '?')).toIndexedSeq
    }
    catch{
      case _: java.io.FileNotFoundException => Nil
    }
  }

  def istAusgang(p: Pos, l: Labyrinth) = {
    val z = l(p.x)(p.y)
    z.frei && (p.x == 0 || p.x == l(0).length - 1 || p.y == 0 || p.y == l.length - 1)
  }

  def freiPos(p : Pos, l: Labyrinth) = {
    val z = l(p.x)(p.y)
    z.frei || z.start
  }

  def gueltig(p: Pos, l: Labyrinth) = {
    p.x >= 0 && p.x < l(0).length && p.y >= 0 && p.y < l.length
  }

  def findStart(l: Labyrinth): Pos = {
    for(z <- 0 until l.length)
      for(s <- 0 until l(z).length)
        if(l(z)(s).start)
          return Pos(z,s)
    return Pos(-1,-1)
  }

  /**
    * Depth-First-Search-Kickoff( Maze m )
    * Depth-First-Search( m.StartCell )
    * End procedure
    **
    *Depth-First-Search( MazeCell c )
    *If c is the goal
    *Exit
    *Else
    *Mark c "Visit In Progress"
    *Foreach neighbor n of c
    *If n "Unvisited"
    *Depth-First-Search( n )
    *Mark c "Visited"
    *End procedure
    */

  def depthFirst(p: Pos, l: Labyrinth, visited: List[Pos]): Pos = {

    if (istAusgang(p, l)){
      println(visited)
      p
    }
    else{
      if((!visited.contains(p.nord) && gueltig(p.nord, l))){
        depthFirst(p.nord, l, append(visited, p))
      }
      if((!visited.contains(p.ost) && gueltig(p.ost, l))){
        depthFirst(p.ost, l, append(visited, p))
      }
      if((!visited.contains(p.sued) && gueltig(p.sued, l))){
        depthFirst(p.sued, l, append(visited, p))
      }
      if((!visited.contains(p.west) && gueltig(p.west,l))){
        depthFirst(p.west, l, append(visited, p))
      }
      p
    }
  }

  def append(l: List[Pos], s: Pos): List[Pos] = {
    if (l.isEmpty) {
      List(s)
    } else {
      l.head :: append(l.tail, s)
    }
  }



}
