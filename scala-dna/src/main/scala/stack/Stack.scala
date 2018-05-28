package stack

trait Stack[T] {

  def push(item: T): Unit

  def pop(): T

  def size: Int

  def isEmpty: Boolean = {
    if (size == 0) true
    else false
  }

}
