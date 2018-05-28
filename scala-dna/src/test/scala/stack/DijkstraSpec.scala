package stack

import org.scalatest.FunSpec

class DijkstraSpec extends FunSpec {

  describe("Dijkstra") {
    it("should properly evaluate a group of expressions") {
      assert(Dijkstra("stack/130.txt") == 101)
    }
    it("should properly evaluate a sqrt") {
      assert(Dijkstra("stack/sqrt.txt") == 4)
    }
  }

}
