package stack

class StackArray[T] extends Stack[T] {

  protected var data: List[T] = List.empty[T]

  def push(item: T): Unit = {

    /**
      * Prepend a single item
      */
    data = item :: data
  }

  def pop(): T = {
    data.headOption match {
      case Some(d) =>
        data = data.drop(1)
        d
      case None => throw new UnsupportedOperationException
    }
  }

  def size: Int = data.size

}
