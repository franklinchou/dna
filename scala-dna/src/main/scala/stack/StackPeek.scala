package stack

class StackPeek[T] extends ArrayStack[T] with Peek[T] {

  def peek():T = {
    data.headOption match {
      case Some(d) => d
      case None => throw new UnsupportedOperationException
    }
  }

}
