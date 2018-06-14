package stack

import org.scalatest.FunSpec

class StackListSpec extends FunSpec {

  describe("Stack using linked list") {

    val t = new StackList[Char]
    it ("can be instantiated") {
      assert(t.isInstanceOf[StackList[Char]])
    }

    it("supports push") {
      assert(t.isEmpty)
      t.push('f')
      assert(!t.isEmpty)
      assert(t.size == 1)
      t.push('o')
      t.push('x')
      assert(t.size == 3)
    }


    it("supports peek") {
      assert(t.peek() == 'x')
    }

    it("supports pop") {
      assert(t.pop() == 'x')
      assert(t.size == 2)
      assert(t.pop() == 'o')
      assert(t.pop() == 'f')
    }

    it("should not pop an empty stack") {
      assertThrows[UnsupportedOperationException] {
        t.pop()
      }
    }
  }

}
