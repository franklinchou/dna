package node

object Node {

  type World = Array[Array[Int]]

}


case class Node[T](data: T, var next: Option[Node[T]])