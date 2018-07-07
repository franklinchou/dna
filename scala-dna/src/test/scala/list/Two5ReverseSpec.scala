package list

import node.Node
import org.scalatest.FunSpec

class Two5ReverseSpec extends FunSpec {

  type LinkedList[T] = Option[Node[T]]

  describe("Two sets of numbers in order") {
    it("should have result") {
      val aComplete = Some(Node(6, Some(Node(1, Some(Node(7, None)))))) // 617
      val bComplete = Some(Node(2, Some(Node(9, Some(Node(5, None)))))) // 295
      assert(Two5Reverse.add(aComplete, bComplete) == List(9, 1, 2))
    }

    it("should have result (recursive)") {
      val aComplete = Some(Node(6, Some(Node(1, Some(Node(7, None)))))) // 617
      val bComplete = Some(Node(2, Some(Node(9, Some(Node(5, None)))))) // 295
      assert(Two5Reverse.addRec(aComplete, bComplete) == List(9, 1, 2))
    }
  }

}
