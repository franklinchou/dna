package stack

trait Peek[T] extends Stack[T] {

  def peek(): T

}
