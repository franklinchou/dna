package list

import node.Node

import scala.annotation.tailrec


/**
  * Add two linked lists storing numbers in left to right order
  *
  * Warning! Does not pad zeroes so a & b must be the same size.
  */
object Two5Reverse {

  type LL[T] = Option[Node[T]]

  private def getVal(n: LL[Int]): Int = n.map(x => x.data).getOrElse(0)

  private def getNextVal(n: LL[Int]): Int = n.flatMap(_.next).map(_.data).getOrElse(0)

  def add(a: LL[Int], b: LL[Int]): List[Int] = {

    var result = List.empty[Int]

    var aHead = a
    var bHead = b

    while (aHead.isDefined && bHead.isDefined) {
      def fastA = getNextVal(aHead)

      def fastB = getNextVal(bHead)

      val ones = (getVal(aHead) + getVal(bHead)) % 10

      if (fastA + fastB >= 10) {
        result = result :+ ones + 1
      } else {
        result = result :+ ones
      }

      aHead = aHead.flatMap(_.next)
      bHead = bHead.flatMap(_.next)
    }
    result
  }


  def addRec(a: LL[Int], b: LL[Int]): List[Int] = {

    @tailrec
    def recurse(a: LL[Int], b: LL[Int], builder: List[Int] = List.empty[Int]): List[Int] = {
      if (a.isEmpty && b.isEmpty) {
        builder
      } else {
        val aNext = getNextVal(a)
        val bNext = getNextVal(b)

        val ones = (getVal(a) + getVal(b)) % 10

        if (aNext + bNext >= 10) {
          recurse(a.flatMap(_.next), b.flatMap(_.next), builder :+ ones + 1)
        } else {
          recurse(a.flatMap(_.next), b.flatMap(_.next), builder :+ ones)
        }
      }
    }

    recurse(a, b)
  }


}
