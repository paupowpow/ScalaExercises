object Labyrinth {
  def main(args: Array[String]){
    val lab : Labyrinth = (liesLab("/Users/paulahaertel/Programmierung/ScalaExercises/src/Abgabe04/laby3-2.txt"))
    //    println(lab)
    //    println(findStart(lab))
    //    println(istAusgang(Pos(31,13), lab))
    //    println(gueltig(Pos(0,0), lab))
    for(z <- 0 until lab.length)
      for(s <- 0 until lab(z).length)
        if(istAusgang(Pos(z,s),lab))
          println("Ausgang: " + Pos(z,s))

    println(depthFirst(findStart(lab), lab, List(), List()))
  }

  case class Zelle(frei: Boolean, start: Boolean)

  case class Pos(x: Int, y: Int){
    def nord = Pos(x-1, y)
    def sued = Pos(x+1, y)
    def ost = Pos(x, y+1)
    def west = Pos(x, y-1)
    override def toString = "(" + x + ", " + y + ")"
  }

  type Labyrinth = Seq[Seq[Zelle]]

  def liesLab(fu: String): Labyrinth = {
    try{
      (for(zeile <- io.Source.fromFile(fu, "UTF-8").getLines.toList)
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
    	Depth-First-Search( m.StartCell )
		End procedure

		Depth-First-Search( MazeCell c )
    	If c is the goal
     	   Exit
   		 Else
        Mark c "Visit In Progress"
        Foreach neighbor n of c
            If n "Unvisited"
                Depth-First-Search( n )
        Mark c "Visited"
			End procedure
    */

  def depthFirst(p: Pos, l: Labyrinth, visited: List[Pos], results: List[Pos]): (Pos, List[Pos]) = {

    if (istAusgang(p, l)){
      println("ist Ausgang: " + append(visited,p))
      (p, append(visited,p))

    } else {
      if( !visited.contains(p.nord) && gueltig(p.nord, l) && freiPos(p.nord, l)){
        depthFirst(p.nord, l, append(visited, p), results)
      }
      if( !visited.contains(p.west) && gueltig(p.west,l) && freiPos(p.west, l) ){
        depthFirst(p.west, l, append(visited, p), results)
      }
      if( !visited.contains(p.sued) &&  gueltig(p.sued, l) && freiPos(p.sued, l) ){
        depthFirst(p.sued, l, append(visited, p), results)
      }
      else if( !visited.contains(p.ost) && gueltig(p.ost, l) && freiPos(p.ost, l)){
        depthFirst(p.ost, l, append(visited, p), results)
      }
    }
    (p,visited)
  }

  def append(l: List[Pos], s: Pos): List[Pos] = {
    if (l.isEmpty) {
      List(s)
    } else {
      l.head :: append(l.tail, s)
    }
  }
}