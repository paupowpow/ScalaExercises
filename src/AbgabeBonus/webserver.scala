import java.net._


object Webserver {

  val default_serverport = 8888

  def main (args: Array[String]) {
    val port = try {
      args (0).toInt
    } catch {
      case _: Throwable ⇒ default_serverport
    }
    println ("Port: " + port)

    server (port)
  }

  def server (port: Int) {
    server (new ServerSocket (port))
  }

  def server (ss: ServerSocket) {
    while (true) new HTTPConnection (ss.accept)
  }

}


class HTTPConnection (s: Socket)
  extends Thread {

  start

  def response (html: String, code: String = "200 OK") = {
    """HTTP/1.0 """ + code + """
Content-Type: text/html
Content-Length: """ + html.length + """

                                    """ + html
  }

  def respond (s: Socket) {
    try {
      println ("responding")
      s.getOutputStream.write (response (<b>Moin</b>.toString).getBytes)
    } finally {
      s.close
    }
  }

  override def run {
    respond (s)
  }

}