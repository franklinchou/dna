package graphs.connected

import node.Node.World
import org.scalatest.FunSpec
import utils.File

class MaxConnectedSpec extends FunSpec {


  private def load(fname: String): World =
    File
      .read(fname)
      .map(line => line.split(",").map(_.toInt))
      .toArray



  describe("") {
    it("") {
      load("connected/max-connected-1.txt")
    }
  }

}
