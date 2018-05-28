package stack.parentheses

import stack.ListStack

object DuplicateParentheses {

  def stringify(m: Map[Boolean, String]): String = {
    if (m.keys.forall(_ == false)) {
      "No duplicate parentheses found"
    } else {
      val expression = StringBuilder.newBuilder
      m.filterKeys(_ == true).map { v =>
        val expr = v._2
        expression.append(s"Duplicate parentheses found in sub-expression $expr")
      }
      expression.mkString
    }
  }

  def apply(input: String): String = {

    var chars: List[Char] = input.toList

    val openingStack = new ListStack[Char]

    var subexpression = StringBuilder.newBuilder

    var duplicate: Boolean = false

    var consensus: Map[Boolean, String] = Map.empty

    while (chars.nonEmpty) {

      val c = chars.head

      if (opening contains c) {
        openingStack.push(c)
      } else if (closing contains c) {
        openingStack.pop()
        if (openingStack.size > 0) {
          duplicate = true
        } else if (openingStack.isEmpty && duplicate) {
          subexpression.append(c)
          consensus = consensus ++ Map(true -> subexpression.mkString)
          subexpression = StringBuilder.newBuilder
          duplicate = false
        }
      } else {
        // If it's not a closing or opening brace, do nothing.
      }

      if (openingStack.size > 0) {
        subexpression.append(c)
      }


      chars = chars.drop(1)
    }

    stringify(consensus)
  }

}
