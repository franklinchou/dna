package graphs.connected

import node.Node.World
import node.graphs.connected.MaxConnected
import org.scalatest.FunSpec
import utils.File

class MaxConnectedSpec extends FunSpec {


  private def load(fname: String): World =
    File
      .read(fname)
      .map(line => line.split(",").map(_.toInt))
      .toArray


  describe("Given a test file") {
    it("should find the maximum connected component") {
      val world = load("connected/max-connected-1.txt")
      val result = MaxConnected.apply(world)
      assert(result == 9)
    }
  }

}
