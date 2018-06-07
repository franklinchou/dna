package stack.parentheses

import org.scalatest.FunSpec

class BalanceParenthesesSpec extends FunSpec {

  describe("Balance parentheses") {
    val test = "1+2)*3-4)*5-6)))"
    val expected = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"
    it("should balance an expression") {
      assert(BalanceParentheses(test) == expected)
    }

  }

}
