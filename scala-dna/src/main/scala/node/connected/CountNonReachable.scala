package node.connected

import scala.collection.mutable

case class CountNonReachable(head: Int, size: Int, relationships: Map[Int, Seq[Int]])


object CountNonReachable {

  /**
    * Given an undirected graph and a set of vertices, count the number of non-reachable
    * nodes from the given head node using depth first search.
    *
    * @param root
    * @param size
    * @param relationships
    */
  def countDFS(root: Int, size: Int, relationships: Map[Int, Seq[Int]]): Int = {
    0
  }


  /**
    * With BFS
    *
    * @param root
    * @param size
    * @param relationships
    * @return
    */
  def countBFS(root: Int, size: Int, relationships: Map[Int, Seq[Int]]): Int = {

    val visited = Array.fill(size)(false)

    var count = size

    /**
      * When implementing bfs, first create the queue and enqueue the root.
      */
    val q = mutable.Queue[Int]()
    q.enqueue(root)

    visited(root) = true
    count -= 1

    while (q.nonEmpty) {
      val source = q.dequeue()
      val adj: Option[Seq[Int]] = relationships.lift.apply(source)

      for {
        n <- adj
        y <- n
      } {
        if (!visited(y)) {
          visited(y) = true
          count -= 1
        }
        q.enqueue(y)
      }
    }
    count
  }


  def apply(method: String, root: Int, size: Int, relationships: Map[Int, Seq[Int]]): Int = {
    method match {
      case "bfs" => countBFS(root, size, relationships)
      case "dfs" => countDFS(root, size, relationships)
    }
  }
}
