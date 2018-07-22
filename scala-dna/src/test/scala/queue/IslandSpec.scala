package queue

import org.scalatest.FunSpec
import node.graphs.island.Island
import node.graphs.island.Island.World
import utils.File

class IslandSpec extends FunSpec {

  /**
    * Make test matrix from file
    *
    * @param testFile
    * @return
    */
  private def makeTestMatrix(testFile: String): World = {
    File
      .read(testFile)
      .toList
      .map(line => line.split(",").map(r => r.toInt))
      .toArray
  }

  describe("Find islands in a static file") {
    it("should find two islands in 5x5 grid") {
      val m = makeTestMatrix("island/5.csv")
      assert(Island.countIslands(m) == 2)
    }
    it("should find five islands in 10x10 grid") {
      val m = makeTestMatrix("island/10.csv")
      assert(Island.countIslands(m) == 5)
    }
    it("should find 7 islands in 25x25 grid") {
      val m = makeTestMatrix("island/25.csv")
      assert(Island.countIslands(m) == 7)
    }
  }

}
