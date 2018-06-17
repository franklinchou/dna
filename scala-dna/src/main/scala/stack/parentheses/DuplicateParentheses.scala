package stack.parentheses

import stack.StackList


/**
  * Find duplicate parentheses in a sub expression
  *
  * http://www.techiedelight.com/find-duplicate-parenthesis-expression/
  */
object DuplicateParentheses {

  def apply(input: String): String = {
    var chars: List[Char] = input.toList

    val operands = new StackList[String]
    val operators = new StackList[Char]
    val openings = new StackList[Char]

    var duplicates = false

    while (chars.nonEmpty && !duplicates) {
      val c = chars.head
      if (c == '(') {
        openings.push('(')
      } else if (Set('+', '-', '*', '/').contains(c)) {
        operators.push(c)
      } else if (c == ')') {
        // If there are no more operators but still opening braces, there are duplicates.
        if (operators.isEmpty && !openings.isEmpty) {
          duplicates = true
        } else {
          val b = operands.pop()
          val a = operands.pop()
          openings.pop()
          val expr = s"($a${operators.pop()}$b)"
          operands.push(expr)
        }
      } else {
        operands.push(c.toString)
      }
      chars = chars.drop(1)
    }


    if (duplicates) {
      "Found duplicate parentheses"
    } else {
      "No duplicate parentheses"
    }

  }
}
