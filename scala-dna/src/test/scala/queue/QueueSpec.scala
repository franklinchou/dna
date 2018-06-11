package queue

import org.scalatest.FunSpec

class QueueSpec extends FunSpec {

  describe("Queue") {
    val q = new QueueList[Int]

    it("should support enqueue") {
      q.enqueue(1)
      q.enqueue(2)
      q.enqueue(3)
      q.enqueue(4)
      assert(q.size == 4)
    }
    it("should support dequeue") {
      var expected = List(1, 2, 3, 4)
      while (q.peek().isDefined) {
        assert(q.dequeue() == expected.headOption)
        expected = expected.drop(1)
      }
      assert(q.size == 0)
    }
  }


}
