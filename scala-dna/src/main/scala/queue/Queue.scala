package queue


/**
  * First in first out (FIFO) queue
  *
  * @tparam T
  */
trait Queue[T] {

  /**
    * Add an element to the queue's tail
    */
  def enqueue(item: T): Unit

  /**
    * View the head of the queue without removing it, returns `None` if the queue is empty.
    */
  def peek(): Option[T]

  /**
    * Similar to `pop` in stack implementation; removes and returns the head of a queue
    */
  def dequeue(): Option[T]

  def size: Int

  def isEmpty: Boolean = {
    if (size == 0) true
    else false
  }

}
