package stack

import node.Node

class StackList[T] extends Stack[T] with Peek[T] {

  private var top: Option[Node[T]] = _

  private var total: Int = 0

  def push(item: T): Unit = {
    val o = top
    val n = Node(item, o)
    total = total + 1
    top = Some(n)
  }

  def pop(): T = {
    if (size > 0) {
      val t = top
      top = t.get.next
      total = total - 1
      t.get.data
    } else {
      throw new UnsupportedOperationException
    }
  }

  def size: Int = total

  override def isEmpty: Boolean = top == null

  def peek(): T = top.get.data
}