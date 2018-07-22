package node.graphs.connected

import node.Node.World
import utils.Point

object MaxConnected {


  def apply(world: World): Int = {

    val worldHSize = world.length // horizontal world size (x)

    val worldVSize = world(0).length // vertical world size (y)


    for {
      x <- 0 until worldHSize
      y <- 0 until worldVSize
    } {
      val source = Point(x, y)


    
    }


    0
  }

}


case class MaxConnected(world: World) {



}