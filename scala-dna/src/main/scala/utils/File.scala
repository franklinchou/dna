package utils

import scala.io.Source

object File {

  def read(fname: String) = {
    Source.fromResource(fname).getLines()
  }
}
