package queue.bfs

import org.scalatest.FunSpec
import queue.bfs.counting.{Node, TreesInForest}

class TreesInForestSpec extends FunSpec {

  describe("Given a multi-nested forest") {
    it("should find 3 trees") {
      val forest: Array[Node] = Array(
        new Node(9, Set.empty[Node]),
        new Node(0, Set(new Node(1), new Node(2))),
        new Node(2, Set(new Node(3))),
        new Node(3, Set(new Node(4), new Node(5))),
        new Node(6, Set(new Node(7), new Node(8)))
      )
      assert(TreesInForest.countTrees(forest, 10) == 3)
    }

    it("should also find 3 trees") {
      val forest: Array[Node] = Array(
        new Node(0, Set.empty[Node]),
        new Node(9, Set(new Node(1), new Node(2))),
        new Node(2, Set(new Node(3))),
        new Node(3, Set(new Node(4), new Node(5))),
        new Node(6, Set(new Node(7), new Node(8)))
      )
      assert(TreesInForest.countTrees(forest, 10) == 3)
    }
    it("should find 2 trees") {
      val forest: Array[Node] = Array(
        new Node(0, Set(new Node(1), new Node(2))),
        new Node(1, Set(new Node(3), new Node(5))),
        new Node(4, Set(new Node(6)))
      )
      assert(TreesInForest.countTrees(forest, 7) == 2)
    }
  }

  describe("Base example") {
    it("should find 2 trees") {
      val forest: Array[Node] =
        Array(
          new Node(0, Set(new Node(1), new Node(2))),
          new Node(3, Set(new Node(4)))
        )
      assert(TreesInForest.countTrees(forest, 5) == 2)
    }
  }

  describe("Given a single tree") {
    it("should find 1 tree") {
      val tree: Array[Node] =
        Array(
          new Node(0, Set(new Node(1))),
          new Node(1, Set(new Node(2))),
          new Node(2, Set(new Node(3)))
        )
      assert(TreesInForest.countTrees(tree, 4) == 1)
    }
  }
}
