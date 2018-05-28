package stack

import org.scalatest.FunSpec

class ListArrayStackPeekSpec extends FunSpec {

  private def addString(a: String, s: StackPeek[Char]): Unit = {
    a.toList foreach { c => s.push(c) }
  }

  describe("Stack with peek") {
    val stackPeek = new StackPeek[Char]
    it("supports peek") {
      addString("justatest", stackPeek)
      assert(stackPeek.size == 9)
      assert(stackPeek.peek() == 't')
      assert(stackPeek.size == 9)
    }

    it("should inherit `isEmpty`") {
      assert(!stackPeek.isEmpty)
    }
  }

}
