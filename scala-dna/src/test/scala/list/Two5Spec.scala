package list

import node.Node
import org.scalatest.FunSpec

class Two5Spec extends FunSpec {

  type LinkedList[T] = Option[Node[T]]

  describe("Complete + Complete") {
    it ("should have result") {
      val aComplete = Some(Node(7, Some(Node(1, Some(Node(6, None)))))) // 617
      val bComplete = Some(Node(5, Some(Node(9, Some(Node(2, None)))))) // 295
      assert(Two5.add(aComplete, bComplete) == List(2, 1, 9))
    }
  }

  describe("Incomplete + Complete") {
    val complete = Some(Node(7, Some(Node(1, Some(Node(6, None)))))) // 617
    val incomplete = Some(Node(6, Some(Node(9, None)))) // 96
    it("should have a result") {
      assert(Two5.add(complete, incomplete) == List(3, 1, 7))
    }
  }

}
