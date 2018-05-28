package stack

import node.Node

class ListStack[T] extends Stack[T] with Peek[T] {

  private var top: Node[T] = _

  private var total: Int = 0

  def push(item: T): Unit = {
    val o = top
    val n = Node(item, o)
    total = total + 1
    top = n
  }

  def pop(): T = {
    if (size > 0) {
      val t = top
      top = t.next
      total = total - 1
      t.data
    } else {
      throw new UnsupportedOperationException
    }
  }

  def size: Int = total

  override def isEmpty: Boolean = top == null

  def peek(): T = top.data
}