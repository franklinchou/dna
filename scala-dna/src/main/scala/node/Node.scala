package node

case class Node[T](data: T, var next: Node[T])
