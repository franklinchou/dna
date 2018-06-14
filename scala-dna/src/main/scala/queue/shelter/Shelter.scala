package queue.shelter

import queue.QueueList

object Shelter {

  def apply: Shelter = new Shelter()

}


class Shelter {

  private val dogQ = new QueueList[Dog]

  private val catQ = new QueueList[Cat]

  def isEmpty: Boolean = dogQ.isEmpty && catQ.isEmpty

  def size: Int = dogQ.size + catQ.size

  def enqueue[A <: Animal](a: A): Unit = {
    a match {
      case d: Dog => dogQ.enqueue(d)
      case c: Cat => catQ.enqueue(c)
      case _ => throw new UnsupportedOperationException
    }
  }

  def dequeue: Option[Animal] = {
    val c = catQ.peek()
    val d = dogQ.peek()

    (c, d) match {
      case (Some(cat), Some(dog)) =>
        if (cat.age < dog.age) catQ.dequeue() else dogQ.dequeue()
      case (Some(_), None) => catQ.dequeue()
      case (None, Some(_)) => dogQ.dequeue()
      case (None, None) => None
    }
  }

  def dequeueDog: Option[Animal] = {
    dogQ.dequeue()
  }

  def dequeueCat: Option[Animal] = {
    catQ.dequeue()
  }
}