package queue

import stack.StackList


/**
  * Implements a queue using two stacks where the dequeue method is expensive.
  *
  * @tparam T
  */
class QueueStackEnqFast[T] extends Queue[T] {

  val in = new StackList[T]

  val out = new StackList[T]

  /**
    * Add an element to the queue's tail
    */
  def enqueue(item: T): Unit = {
    in.push(item)
  }

  /**
    * View the head of the queue without removing it, returns `None` if the queue is empty.
    */
  def peek(): Option[T] = {
    if (in.isEmpty) {
      None
    } else {
      Some(in.peek())
    }
  }

  /**
    * Similar to `pop` in stack implementation; removes and returns the head of a queue
    */
  def dequeue(): Option[T] = {
    if (in.isEmpty && out.isEmpty) {
      None
    } else {
      while (!in.isEmpty) {
        out.push(in.pop())
      }
      Some(out.pop())
    }
  }

  def size: Int = in.size
}
