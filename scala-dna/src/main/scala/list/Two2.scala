package list

import node.Node


/**
  * Non-naive solutions to 2-2, i.e., where length of the list is unknown.
  */
object Two2 extends App {


  // TODO Functional way to write this? As a fold?
  private val testCase = Node('a', Some(Node('b', Some(Node('c', Some(Node('d', Some(Node('e', None)))))))))

  /**
    * Find the kth to last element using two pointers (iteratively).
    *
    * @param head
    * @param k
    * @tparam T
    * @return
    */
  def pointers[T <: AnyVal](head: Node[T], k: Int): T = {

    var end = head
    var sought = head

    // Go to the sought value (k)
    var index = 1
    while (index != k) {
      end = end.next.get
      index += 1
    }

    while (end.next.isDefined) {
      sought = sought.next.get
      end = end.next.get  // unchecked get should never be empty
    }
    sought.data
  }


  def pointersClient(): Unit = {
    println(pointers(testCase, 1))  // Finds the last element, expected 'e'
    println(pointers(testCase, 2))  // Finds the second to last element, expected 'd'
    println(pointers(testCase, 4))  // 'b'
  }

  /**
    * Find the kth to last element using recursion.
    *
    * @param head
    * @param k
    * @tparam T
    * @return
    */
  def recursive[T <: AnyVal](head: Node[T], sought: Int, k: Int = 0): Int = {
    0
  }





  /**
    * Tests
    */
  pointersClient()
  // recursive(t, )

}
