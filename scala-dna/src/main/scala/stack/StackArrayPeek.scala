package stack

class StackArrayPeek[T] extends StackArray[T] with Peek[T] {

  def peek():T = {
    data.headOption match {
      case Some(d) => d
      case None => throw new UnsupportedOperationException
    }
  }

}
