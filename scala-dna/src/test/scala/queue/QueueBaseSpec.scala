package queue

import org.scalatest.FlatSpec


case class QueueBaseSpec[T <: Any](q: Queue[T]) extends FlatSpec with QueueBehaviours[T] {

  final val expected = 0 to 9

  /**
    * Populated queue
    */
  "A populated queue" should "support dequeue" in {
    val temp = q.asInstanceOf[Queue[Int]]
    expected.foreach(e => temp.enqueue(e))

    for (e <- expected) {
      assert(temp.dequeue().contains(e))
    }
  }

  it should behave like anyQueue(q)


  /**
    * Empty queue
    */
  "An empty queue" should behave like emptyQueue(q)

  it should behave like anyQueue(q)
}
