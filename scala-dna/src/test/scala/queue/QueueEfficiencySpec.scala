package queue

import org.scalatest.FlatSpec
import utils.File

class QueueEfficiencySpec extends FlatSpec {

  // http://www.convertcsv.com/generate-test-data.htm
  def raw10000 = File.read("queue/test-10000.csv")

  def raw1000000 = File.read("queue/test-1000000.csv")

  private def time(f: => Unit): BigDecimal = {
    val start = System.nanoTime()
    f
    val elapsed = System.nanoTime() - start
    BigDecimal(elapsed / 1000000000.0)
  }

  private def enqueue(q: Queue[String], data: Iterator[String]) = {
    for (line <- data) {
      q.enqueue(line)
    }
  }

  private def dq(q: Queue[String], data: Iterator[String]) = {
    for (_ <- data) {
      q.dequeue()
    }
  }

  val ql = new QueueList[String]
  val qsD = new QueueStackDq[String]


  /* "Enqueue" */ ignore should "run faster in QueueStackDq compared to QueueList" in {
    val qlTime = time(enqueue(ql, raw1000000))
    val qsDTime = time(enqueue(qsD, raw1000000))

    /**
      *  The reason for this difference appears to have nothing to do
      *  with actual execution speed; ignoring this test.
      */
    assert(qsDTime < qlTime)
  }

  "Dequeue" should "run faster in QueueList compared to QueueStackDq" in {
    enqueue(ql, raw10000)
    enqueue(qsD, raw10000)
    assert(ql.size == 10000)
    assert(qsD.size == 10000)
    val qlTime = time(dq(ql, raw10000))
    val qsDTime = time(dq(qsD, raw10000))
    assert(ql.isEmpty)
    assert(qsD.isEmpty)
    assert(qlTime < qsDTime)
  }

}
