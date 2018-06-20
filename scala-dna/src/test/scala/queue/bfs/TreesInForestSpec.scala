package queue.bfs

import org.scalatest.FunSpec
import queue.bfs.counting.{Node2, TreesInForest}

class TreesInForestSpec extends FunSpec {

  ignore("Given a forest of size 2") {
    it("should find 2 trees") {
      val forest: Array[Node2] =
        Array(
          new Node2(0, 1),
          new Node2(0, 2),
          new Node2(3, 4)
        )
      assert(TreesInForest.countTrees(forest, 5) == 2)
    }
  }

  describe("Given a forest of size 3") {
    it("should find 3 trees") {
      val forest: Array[Node2] =
        Array(
          new Node2(9, 2),
          new Node2(6, 10),
          new Node2(9, 3),
          new Node2(1, 6),
          new Node2(1, 4),
          new Node2(8, 7),
          new Node2(8, 5),
          new Node2(5, 0)
        )
      assert(TreesInForest.countTrees(forest, 11) == 3)
    }
  }

  describe("Given a forest of size 5") {
    it("should find 5 trees") {
      val forest: Array[Node2] =
        Array(
          new Node2(0, 1),
          new Node2(2, 3),
          new Node2(4, 5),
          new Node2(6, 7),
          new Node2(8, 9)
        )
      assert(TreesInForest.countTrees(forest, 10) == 5)
    }
  }
}
