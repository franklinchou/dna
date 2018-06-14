package node

case class Node[T](data: T, var next: Option[Node[T]])
