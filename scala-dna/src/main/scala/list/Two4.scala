package list

import node.Node

object Two4 extends App {

  def partitionAbout(head: Option[Node[Int]], p: Int): Node[Int] = {

    val partition = Node(p, None) // create the new partition node

    var h = head
    var greater = partition
    var less = partition

    while (h.isDefined) {

      if (h.get.data < p) {
        // Prepend to list
        val t = Node(h.get.data, Some(less))
        less = t
      } else if (h.get.data > p) {
        // Append to list
        val t = Node(h.get.data, None)
        greater.next = Some(t)
        greater = t
      } else {
        // If the value is equal to partition, do nothing
      }
      h = h.get.next
    }

    // At the end of the function less is the new head
    less
  }


  private def list2String(head: Option[Node[Int]]): String = {
    val b = StringBuilder.newBuilder
    var h = head
    while (h.isDefined) {
      b.append(s"${h.get.data},")
      h = h.get.next

    }
    b.append("null")
    b.toString()
  }

  val test = Some(Node(5, Some(Node(6, Some(Node(4, Some(Node(2, Some(Node(3, Some(Node(1, None))))))))))))

  val r1 = partitionAbout(test, 7)
  val r2 = partitionAbout(test, 3)

  require(list2String(Some(r1)) == "1,3,2,4,6,5,7,null")
  require(list2String(Some(r2)) == "1,2,3,5,6,4,null")

}
