package stack.parentheses

import org.scalatest.FunSpec

class ParenthesesSpec extends FunSpec {

  describe("Testing Parentheses") {
    it ("should pass") {
      val pass = "[()]{}{[()()]()}"
      assert(Parentheses(pass))
    }
    it ("should fail") {
      val fail = "[(])"
      assert(!Parentheses(fail))
    }
  }

}
