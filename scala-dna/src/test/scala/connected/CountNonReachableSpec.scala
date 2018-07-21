package connected

import node.connected.{CountNonReachable, Relationships}
import org.scalatest.FunSpec

class CountNonReachableSpec extends FunSpec {

  private def count(source: String, method: String, root: Int = 0): Int = {
    val r = Relationships.load(source)
    val size = r._1 // number of nodes in this graph
    val graph = Relationships.makeGraph(r._2)
    CountNonReachable.apply(method, root, size, graph)
  }

  // map of test file to expected
  private val tests = {
    Map(
      "connected/test1.txt" -> 2,
      "connected/test2.txt" -> 5
    )
  }


  describe("Count non-reachable nodes with bfs") {
    tests.foreach { t =>
      val source = t._1
      it(s"test $source") {
        assert(count(source, "bfs") == t._2)
      }
    }
  }


  describe("Count non-reachable nodes with dfs") {
    tests.foreach { t =>
      val source = t._1
      it(s"test $source") {
        assert(count(source, "dfs") == t._2)
      }
    }
  }

}

