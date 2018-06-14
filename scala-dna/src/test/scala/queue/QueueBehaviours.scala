package queue

import org.scalatest.FlatSpec

trait QueueBehaviours[T <: Any] { this: FlatSpec =>

  def anyQueue(q: => Queue[T]) {

    it should "support enqueue" in {
      val prior = q.size

      q match {
        case _: Queue[Int] => q.asInstanceOf[Queue[Int]].enqueue(1)
        case _: Queue[String] => q.asInstanceOf[Queue[String]].enqueue("1")
        case _ => throw new ClassCastException
      }

      assert(q.size == prior + 1)
    }

    it should "return to empty state" in {
      q.dequeue()
      assert(q.isEmpty)
    }

  }

  def emptyQueue(q: => Queue[T]) {
    it should "start as empty" in {
      assert(q.size == 0)
      assert(q.isEmpty)
    }
    it should "not support dequeue" in {
      assert(q.dequeue().isEmpty)
    }
  }

}
