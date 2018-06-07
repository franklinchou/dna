package stack.parentheses

import stack.ListStack


// input: 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
// output: ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
object BalanceParentheses {

  private final val binaryOperators = Set('+', '-', '*', '/', '^')

  def apply(input: String): String = {

    var chars: List[Char] = input.toList

    val operators = new ListStack[String]
    val operands = new ListStack[String] // numbers

    while (chars.nonEmpty) {
      val c = chars.head

      if (c == ')') {
        val a = operands.pop()
        val b = operands.pop()
        val op = operators.pop()
        val expr = s"( $b $op $a )"
        operands.push(expr)
      } else if (binaryOperators.contains(c)) {
        operators.push(c.toString)
      } else {
        operands.push(c.toString)
      }

      chars = chars.drop(1)
    }

    assert(operands.size == 1)
    operands.pop()
  }
}
