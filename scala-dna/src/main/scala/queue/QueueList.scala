package queue

import node.Node

class QueueList[T] extends Queue[T] {

  private var tail: Option[Node[T]] = None

  private var head: Option[Node[T]] = None

  private var total: Int = 0

  /**
    * Add an element to the queue's tail
    */
  def enqueue(item: T): Unit = {
    val n = Node(item, None) // Create new node
    if (total == 0) {
      head =  Some(n)
      tail =  Some(n)
    } else {
      tail.get.next = Some(n)
      tail = Some(n)
    }
    assert(tail.isDefined && head.isDefined) // Head & Tail should never be None after enqueue
    total += 1
  }

  /**
    * Similar to `pop` in stack implementation; removes and returns the value of the head
    */
  def dequeue(): Option[T] = {
    if (total == 0) {
      None
    } else {
      val v = head.get.data // Store the data before moving the pointer
      head = head.get.next
      total = total - 1
      Some(v)
    }
  }


  /**
    * View the head of the queue without removing it, returns `None` if the queue is empty.
    */
  def peek(): Option[T] = {
    if (size > 0) {
      Some(head.get.data)
    } else {
      None
    }
  }

  def size: Int = total

}
