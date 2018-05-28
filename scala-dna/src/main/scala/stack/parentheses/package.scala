package stack

package object parentheses {

  final val opening = Set('{', '[', '(')
  final val closing = Set('}', ']', ')')

  final def isMatch(opening: Char, current: Char): Boolean = {
    val sought = current match {
      case ')' => '('
      case ']' => '['
      case '}' => '{'
    }

    if (opening == sought) true
    else false
  }

}
