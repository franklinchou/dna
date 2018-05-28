package bag

import org.scalatest.FunSpec

class BagSpec extends FunSpec {

  // TODO Generalize this
  private def addString(s: String, b: Bag[Char]): Unit = {
    s.toList foreach { c => b.add(c) }
  }

  describe("A bag") {
    val bag = new Bag[Char]

    val test = "calico"

    it("can be instantiated") {
      assert(bag.isInstanceOf[Bag[Char]])
    }

    it("supports add") {
      addString(test, bag)
      assert(bag.size == test.length)
      assert(!bag.isEmpty)
    }

    it("supports grab") {
      (0 to 100).foreach { _ =>
        assert(test contains bag.grab())
        assert(bag.size == test.length)
      }
    }

  }

}
