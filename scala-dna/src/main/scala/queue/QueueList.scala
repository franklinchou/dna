package queue

import node.Node

class QueueList[T] extends Queue[T] {

  private var tail: Node[T] = _

  private var head: Node[T] = _

  private var total: Int = 0


  /**
    * Add an element to the queue's tail
    */
  def enqueue(item: T): Unit = {
    val n = Node(item, null) // Create new node
    if (total == 0) {
      head = n
      tail = n
    }
    total += 1
    tail.next = n
    tail = n
  }

  /**
    * Similar to `pop` in stack implementation; removes and returns the value of the head
    */
  def dequeue(): Option[T] = {
    if (total == 0) {
      None
    } else {
      val v = head.data // Store the data before moving the pointer
      head = head.next
      total = total - 1
      Some(v)
    }
  }


  /**
    * View the head of the queue without removing it, returns `None` if the queue is empty.
    */
  def peek(): Option[T] = {
    if (size > 0) {
      Some(head.data)
    } else {
      None
    }
  }

  def size: Int = total

}
