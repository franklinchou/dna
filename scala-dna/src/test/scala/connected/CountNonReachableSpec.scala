package connected

import node.connected.{CountNonReachable, Relationships}
import org.scalatest.FunSpec

class CountNonReachableSpec extends FunSpec {

  describe("Count non-reachable nodes with bfs") {
    it("test 1") {

      val source = "connected/test1.txt"

      val r = Relationships.load(source)

      val size = r._1 // number of nodes in this graph
      val graph = Relationships.makeGraph(r._2)

      val c = CountNonReachable.apply("bfs", 0, size, graph)
      assert(c == 2)
    }

    it("test 2") {

      val source = "connected/test2.txt"

      val r = Relationships.load(source)

      val size = r._1 // number of nodes in this graph
      val graph = Relationships.makeGraph(r._2)

      val c = CountNonReachable.apply("bfs", 0, size, graph)
      assert(c == 5)
    }
  }

}

