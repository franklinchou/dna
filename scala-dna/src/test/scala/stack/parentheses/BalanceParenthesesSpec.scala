package stack.parentheses

import org.scalatest.FunSpec

class BalanceParenthesesSpec extends FunSpec {

  describe("Balance parentheses") {

    it("should balance an expression") {
      val test = "1+2)*3-4)*5-6)))"
      val expected = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"
      assert(BalanceParentheses(test) == expected)
    }

    it("should balance an expression containing '^' ") {
      val test = "9/c)+c*p^8+9))))"
      val expected = "( ( 9 / c ) + ( c * ( p ^ ( 8 + 9 ) ) ) )"
      assert(BalanceParentheses(test) == expected)
    }
  }

}
