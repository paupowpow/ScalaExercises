package s0542425

case class RationaleZahl (zaehler: Int, nenner: Int) {  
  
  require(nenner != 0, "Nenner darf nicht 0 sein!")
  
  def this (x: Int) = this(x, 1)
  
//  override def toString = zaehler + "/" + nenner
  
  override def toString =
    zaehler + "/" + nenner

  private ggT (a: Int, b: Int) =
    
    
  private val kuerz_mich = ggT(zaehler, nenner)

}

