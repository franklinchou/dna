package stack

import org.scalatest.FunSpec

class StackArraySpec extends FunSpec {

  describe("A stack implemented with an array") {
    val test = new StackArray[Int]
    it("can be instantiated") {
      assert(test.isInstanceOf[StackArray[Int]])
    }

    it("supports push") {
      test.push(5)
      test.push(6)
      test.push(7)
      test.push(8)
      assert(!test.isEmpty)
      assert(test.size == 4)
    }

    it("supports pop") {
      assert(test.pop == 8)
      assert(test.pop == 7)
      assert(test.pop == 6)
      assert(test.pop == 5)
      assert(test.isEmpty)
      assert(test.size == 0)
    }

    it("should not be able to pop an empty stack") {
      assertThrows[UnsupportedOperationException] {
        test.pop()
      }
    }
  }


}
