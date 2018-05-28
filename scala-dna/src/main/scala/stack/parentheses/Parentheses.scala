package stack.parentheses

import stack.ArrayStack

// p. 161, exercise 1.3.3
object Parentheses {

  val openingStack = new ArrayStack[Char]

  def apply(input: String): Boolean = {

    var in = input.toList

    // The first item will always be an opening brace
    val first = in.head
    assert(opening contains first)
    openingStack.push(first)
    in = in.drop(1)

    var currentOpening = first

    var consensus = List.empty[Boolean]

    while (in.nonEmpty) {

      val current = in.head

      if (opening contains current) {
        currentOpening = current
        openingStack.push(currentOpening)
      } else if (closing contains current) {
        consensus = isMatch(openingStack.pop(), current) :: consensus
        // currentOpening = openingStack.pop()
      } else {
        // Do nothing
      }

      in = in.drop(1)
    }

    consensus.forall(_ == true)
  }
}
