case class RationaleZahl (zaehler: Int, nenner: Int) {

  require(nenner != 0)

  val g = ggT(zaehler, nenner)
  val z = zaehler/g
  val n = nenner/g

  def ggT(zahl1: Int, zahl2: Int): Int = {
    import scala.math.abs
    def loop(zahl1: Int, zahl2: Int): Int = if (zahl2 == 0) zahl1 else loop(zahl2, zahl1%zahl2)
    loop(abs(zahl1), abs(zahl2))
  }

  def add(r: RationaleZahl) = new RationaleZahl(z*r.n + r.z*n, n*r.n)
  def subtract(r: RationaleZahl) = new RationaleZahl(z*r.n - r.z*n, n*r.n)
  def multiply(r: RationaleZahl) = new RationaleZahl(z*r.z, n*r.n)
  def divide(r: RationaleZahl) = new RationaleZahl(z/r.z, n/r.n)

  def this(zaehler: Int) = this(zaehler, 1)

  def equals(zahl2: RationaleZahl): Boolean = if ((z == zahl2.z) && (n == zahl2.n)) true else false

  override def toString(): String = z + "/" + n;
}

object RationaleZahl {
  def main(args: Array[String]) {
    val zahl1 = new RationaleZahl(2, 5)
    val zahl2 = new RationaleZahl(4, 10)
    val zahl3 = new RationaleZahl(1, 4)
    val zahl4 = new RationaleZahl(1, 4)


    println(zahl1)
    println(zahl2)
    println(zahl1.add(zahl2))
    println(zahl3.multiply(zahl4))
    println(zahl1.equals(zahl3))
  }
}