package string

import queue.QueueList
import stack.StackList

object Palindrome {

  private def isEven(i: Int): Boolean = i % 2 == 0

  def isPalindrome(s: String): Boolean = {

    val size = s.length
    val chars: Seq[Char] = s.toList

    val left = new QueueList[Char]
    val right = new StackList[Char]

    val middle: Int =
      if (isEven(size)) {
        size / 2
      } else {
        // If odd, pivot around the middle character
        (size - 1) / 2
      }

    (0 until middle).foreach(i => left.enqueue(chars(i)))

    if (isEven(size)) {
      (middle until size).foreach(i => right.push(chars(i)))
    } else {
      (middle + 1 until size).foreach(i => right.push(chars(i)))
    }

    var palindrome = true
    while (!left.isEmpty) {
      if (left.dequeue().getOrElse('\0') == right.pop()) {
        // do nothing
      } else {
        palindrome = false
      }
    }

    palindrome
  }
}
