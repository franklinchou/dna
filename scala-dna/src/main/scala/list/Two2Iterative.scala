package list

import node.Node

import scala.annotation.tailrec


/**
  * Find the kth to last element using two pointers (iteratively).
  */
object Two2Iterative extends App {


  // TODO Functional way to write this? As a fold?
  private val testCase = Some(Node('a', Some(Node('b', Some(Node('c', Some(Node('d', Some(Node('e', None))))))))))


  type LinkedList[T] = Option[Node[T]]


  @tailrec
  def gotoK[T <: AnyVal](list: LinkedList[T], k: Int, i: Int = 0): LinkedList[T] = {
    list match {
      case Some(v) if i == k => Some(v)
      case Some(v) => gotoK(v.next, k, i + 1)
      case None => None
    }
  }

  @tailrec
  def gotoResult[T <: AnyVal](forward: LinkedList[T], rear: LinkedList[T]): T = {
    forward match {
      case Some(v) => gotoResult(v.next, rear.get.next) // unchecked get should never be empty
      case None => rear.get.data
    }
  }


  def pointers[T <: AnyVal](list: LinkedList[T], k: Int): T = {
    val sought = gotoK(list, k) // Go to the sought value (k)
    gotoResult(sought, list)
  }


  def pointersClient(): Unit = {
    println(pointers(testCase, 1)) // Finds the last element, expected 'e'
    println(pointers(testCase, 2)) // Finds the second to last element, expected 'd'
    println(pointers(testCase, 4)) // 'b'
  }


  /**
    * Tests
    */
  pointersClient()
}
