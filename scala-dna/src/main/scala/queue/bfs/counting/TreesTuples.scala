package queue.bfs.counting

object TreesTuples extends App {


  /**
    * Trivial answer. Uni-directional linkage only.
    *
    * @param nodes
    * @return
    */
  def count(nodes: Array[(Int, Option[Int])]): Int = {

    val keys = nodes.map { n => n._1 }.toSet
    val values = nodes.map { n => n._2 }

    val excluded: Array[Option[Int]] =
      values.filter {
        case Some(v) => !keys.contains(v)
        case None => false
      }

    excluded.length
  }

  val client =
    Array(
      0 -> Some(2),
      0 -> Some(3),
      2 -> Some(1),
      5 -> Some(6),
      4 -> None
    )

  println(count(client))
}
