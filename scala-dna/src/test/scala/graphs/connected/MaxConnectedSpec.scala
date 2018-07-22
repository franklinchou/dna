package graphs.connected

import node.Node.World
import org.scalatest.FunSpec
import utils.File

class MaxConnectedSpec extends FunSpec {


  private def load(fname: String): Int = {
    val q= File
      .read(fname)
      .map(line => line.split(","))

    q

    0

  }


  describe("") {
    it("") {
      load("connected/max-connected-1.txt")
    }
  }

}
