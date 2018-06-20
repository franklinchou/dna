package queue.bfs

import org.scalatest.FunSpec
import queue.bfs.counting.island.Island
import queue.bfs.counting.island.Island.World
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
    it("should find two islands") {
      val m = makeTestMatrix("island/5.csv")
      assert(Island.countIslands(m) == 2)
    }
    it("should find five islands") {
      val m = makeTestMatrix("island/10.csv")
      assert(Island.countIslands(m) == 5)
    }
  }

}
