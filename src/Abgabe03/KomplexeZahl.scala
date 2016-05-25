/**
  * Created by paulahaertel on 25.05.16.
  */
case class KomplexeZahl(re: Double, im: Double) {

  val quad = re*re + im*im

  def add(k: KomplexeZahl) = KomplexeZahl(re+k.re, im+k.im)
  def subtract(k: KomplexeZahl) = KomplexeZahl(re-k.re, im-k.im)
  def multiply(k: KomplexeZahl) = KomplexeZahl(re*k.re - im*k.im, re*k.im + im*k.re)
  def divide(k: KomplexeZahl) = KomplexeZahl((re*k.re + im*k.im) / quad, (im*k.re - re*k.im)/quad)

  override def toString = re + " + i*" + im
}

object KomplexeZahl {
  def main(args: Array[String]) {
    val zahl1 = KomplexeZahl(1.2, 1.5)
    val zahl2 = KomplexeZahl(1.5, 12.0)

    println(zahl1)
    println(zahl2)
    println(zahl1.add(zahl2))
    println(zahl2.subtract(zahl1))
    println(zahl1.multiply(zahl2))
    println(zahl1.divide(zahl2))


  }
}