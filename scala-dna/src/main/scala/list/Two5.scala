package list

import node.Node

import scala.annotation.tailrec

object Two5 {

  type LinkedList[T] = Option[Node[T]]

  private def getVal(n: LinkedList[Int]): Int = {
    n match {
      case Some(v) => v.data
      case None => 0
    }
  }

  private def getNext(n: LinkedList[Int]) = {
    n match {
      case Some(a) => a.next
      case None => None
    }
  }

  def add(a: LinkedList[Int], b: LinkedList[Int]): List[Int] = {

    @tailrec
    def recurse(a: LinkedList[Int],
                b: LinkedList[Int],
                builder: List[Int] = List.empty[Int],
                overflow: Int = 0): List[Int] = {

      if (a.isEmpty && b.isEmpty && overflow == 0) {
        builder
      } else {
        val s = getVal(a) + getVal(b) + overflow
        if (s / 10 > 0) {
          recurse(getNext(a), getNext(b), builder :+ (s % 10), 1)
        } else {
          recurse(getNext(a), getNext(b), builder :+ s)
        }
      }
    }
    recurse(a, b)
  }

}
