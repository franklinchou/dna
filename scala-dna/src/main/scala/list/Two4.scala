package list

import node.Node

import scala.annotation.tailrec

object Two4 extends App {

  type LinkedList[T] = Option[Node[T]]

  private def list2String(list: LinkedList[Int]): String = {
    val b = StringBuilder.newBuilder

    @tailrec
    def traverse(l: LinkedList[Int]): Unit = l match {
      case Some(Node(current, next)) =>
        b.append(s"$current,")
        traverse(next)
      case None =>
        b.append("null")
    }

    traverse(list)
    b.toString()
  }

  def partitionAbout(list: LinkedList[Int], p: Int): Node[Int] = {

    val partition = Node(p, None) // create the new partition node

    var greater = partition
    var less = partition

    @tailrec
    def traverse(l: LinkedList[Int]): Unit = l match {
      case Some(Node(current, next)) =>
        if (current < p) {
          // Prepend to list
          val t = Node(current, Some(less))
          less = t
        } else if (current > p) {
          // Append to list
          val t = Node(current, None)
          greater.next = Some(t)
          greater = t
        } else {
          // If the value is equal to partition, do nothing
        }
        traverse(next)
      case None => ()
    }

    traverse(list)

    // At the end of the function less is the new head
    less
  }

  val test = Some(Node(5, Some(Node(6, Some(Node(4, Some(Node(2, Some(Node(3, Some(Node(1, None))))))))))))

  val r1 = partitionAbout(test, 7)
  val r2 = partitionAbout(test, 3)

  require(list2String(Some(r1)) == "1,3,2,4,6,5,7,null")
  require(list2String(Some(r2)) == "1,2,3,5,6,4,null")
}
