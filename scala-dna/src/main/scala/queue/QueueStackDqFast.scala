package queue

import stack.StackList


/**
  * Implements a queue using two stacks. Enqueue method is expensive.
  */
class QueueStackDqFast[T] extends Queue[T] {

  val s = new StackList[T]

  val temp = new StackList[T]


  /**
    * Add an element to the queue's tail
    */
  def enqueue(item: T): Unit = {
    if (s.isEmpty) {
      s.push(item)
    } else {
      while (!s.isEmpty) {
        temp.push(s.pop())
      }
      temp.push(item) // Add the desired item to the tail
      while (!temp.isEmpty) {
        s.push(temp.pop())
      }
    }
  }

  /**
    * View the head of the queue without removing it, returns `None` if the queue is empty.
    */
  def peek(): Option[T] = {
    if (s.isEmpty) {
      None
    } else {
      Some(s.peek())
    }
  }

  /**
    * Similar to `pop` in stack implementation; removes and returns the head of a queue
    */
  def dequeue(): Option[T] = {
    if (s.isEmpty) {
      None
    } else {
      Some(s.pop())
    }
  }

  def size: Int = s.size
}
