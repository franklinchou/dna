package queue.island

import utils.Point

import scala.collection.mutable.Queue

object Island {

  type World = Array[Array[Int]]

  private def visit(isVisited: World, p: Point): Unit = {
    isVisited(p.x)(p.y) = 1
  }


  /**
    * Check to see whether a given destination point exists.
    *
    * @param world
    * @param d Given destination point
    * @return
    */
  private def isMoveable(world: World, d: Point): Boolean = {

    val r =
      for {
        x <- world.lift(d.x)
        y <- x.lift(d.y)
      } yield y

    r match {
      case Some(_) => true
      case _ => false
    }
  }


  private def isLand(world: World, d: Point): Boolean = world(d.x)(d.y) == 1

  private def moves(source: Point): Seq[Point] = {
    Seq(
      Point(source.x, source.y + 1),
      Point(source.x, source.y - 1),
      Point(source.x + 1, source.y),
      Point(source.x - 1, source.y),
      Point(source.x - 1, source.y + 1),
      Point(source.x + 1, source.y - 1),
      Point(source.x + 1, source.y + 1),
      Point(source.x - 1, source.y - 1)
    )
  }


  def countIslands(w: World): Int = {

    var islands: Int = 0

    // Assuming a square grid
    val size: Int = w.length

    // Keep track of whether a node has been visited or not.
    val isVisited: World = Array.fill(size, size)(0)

    for {
      x <- 0 until size
      y <- 0 until size
    } {
      if (isVisited(x)(y) == 0 && w(x)(y) == 1) {
        val source = Point(x, y) // source node

        val q = Queue[Point]()
        q.enqueue(source)
        visit(isVisited, source)

        while (q.nonEmpty) {
          val source = q.dequeue()
          for (m <- moves(source)) {
            if (isMoveable(w, m) && isVisited(m.x)(m.y) == 0) {
              visit(isVisited, m)
              if (isLand(w, m)) {
                q.enqueue(m)
              }
            }
          }
        }
        islands = islands + 1
      }
    }
    islands
  }
}
