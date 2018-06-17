package queue.island

import java.nio.file.{Files, Paths}

import queue.island.Island.World

import scala.io.Source
import scala.util.Random


/**
  * Build a randomly generated world
  *
  * Run with:
  *
  * sbt "run queue.island.IslandBuilder size"
  */
object IslandBuilder extends App {

  val r = Random

  val size = args(1).toInt

  val world: World = Array.fill(size, size)(r.nextInt(2))

  val path = Source.fromResource(s"/island/${args(1)}.csv")

  val construct: Array[String] =
    world
      .map { row =>
        row.zipWithIndex.map { c =>
          if (c._2 != size - 1) s"${c._1.toString}," else c._1.toString
        }.mkString
      }

  for (c <- construct) {
    println(c)
  }
}
