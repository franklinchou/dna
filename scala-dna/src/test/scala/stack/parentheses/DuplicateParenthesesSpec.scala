package stack.parentheses

import org.scalatest.FunSpec

class DuplicateParenthesesSpec extends FunSpec {

  describe("Duplicate parentheses") {
    val test1 = "((x+y))+z"
    it(s"given $test1, should find duplicates") {
      val expected = "Duplicate parentheses found in sub-expression ((x+y))"
      assert(DuplicateParentheses(test1) == expected)
    }

    val test2 = "(x+y)"
    it(s"given $test2, should find no duplicates") {
      val expected = "No duplicate parentheses found"
      assert(DuplicateParentheses(test2) == expected)
    }

    val test3 = "((x+y)+((z)))"
    it(s"given $test3, should find duplicates") {
      val expected = "Duplicate parentheses found in sub-expression ((z))"
      assert(DuplicateParentheses(test3) == expected)
    }
  }

}
