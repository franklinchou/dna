package node.connected

import utils.File

import scala.collection.immutable

object Relationships {

  /**
    * Generate size and relationships from text file
    *
    * @param f
    */
  def load(f: String): (Int, immutable.Seq[(Int, Int)]) = {
    val lines = File.read(f).toIndexedSeq
    val size = lines(0).toInt
    lazy val relationships =
      lines
        .drop(1)
        .map(line => line.split(" "))
        .map(s => s(0).toInt -> s(1).toInt)

    size -> relationships
  }


  /**
    * Generate a graph (adjacency list) from a sequence of relationships
    *
    * @param relationships
    * @return
    */
  def makeGraph(relationships: Seq[(Int, Int)]): Map[Int, Seq[Int]] = {
    relationships
      .groupBy(_._1)
      .mapValues(_.map(_._2))
  }

}
