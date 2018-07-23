package node.graphs.connected

import node.Node.World
import utils.Point

import scala.collection.mutable


object MaxConnected {

  private def moves(p: Point): Seq[Point] = {
    Seq(
      Point(p.x + 1, p.y),
      Point(p.x - 1, p.y),
      Point(p.x, p.y + 1),
      Point(p.x, p.y - 1)
    )
  }


  def apply(world: World): Int = {

    val worldHSize = world.length // horizontal world size (x)

    val worldVSize = world(0).length // vertical world size (y)

    var largest = 0

    val isMoveable = (p: Point) => {
      (p.x >= 0 && p.y >= 0) && (p.x < worldHSize && p.y < worldVSize)
    }

    // Find the color of a point
    val color = (p: Point) => world(p.x)(p.y)

    for {
      x <- 0 until worldHSize
      y <- 0 until worldVSize
    } {
      val source = Point(x, y)
      val sourceColor = world(x)(y)

      var size = 0

      /**
        * Note: Immutable queue returns the dequeued element and the new queue with
        * that element removed.
        */
      val q = mutable.Queue[Point]()
      val visited = new mutable.HashSet[Point]()

      q.enqueue(source)
      visited.add(source)

      while (q.nonEmpty) {

        val child = q.dequeue
        visited.add(child)
        val childColor = color(child)

        if (childColor == sourceColor) {
          size += 1
        }

        /**
          * Add moves only if they contain a same color element
          */
        for (m <- moves(child)) {
          if (!visited.contains(m) && isMoveable(m) && color(m) == sourceColor) {
            q.enqueue(m)
          }
        }
      }

      largest = Math.max(size, largest)
    }

    largest
  }

}


case class MaxConnected(world: World)