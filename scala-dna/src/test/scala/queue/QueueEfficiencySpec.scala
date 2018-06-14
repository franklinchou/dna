package queue

import org.scalatest.FlatSpec
import utils.File

class QueueEfficiencySpec extends FlatSpec {

  def raw10000 = File.read("queue/test-10000.csv")

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
    val qlTime = time(enqueue(ql, raw10000))
    val qsDTime = time(enqueue(qsD, raw10000))
    assert(ql.size == 10000)
    assert(qsD.size == 10000)
    assert(qsDTime < qlTime)
  }

  "Dequeue" should "run faster in QueueList compared to QueueStackDq" in {
    assert(ql.size == 10000)
    assert(qsD.size == 10000)
    val qlTime = time(dq(ql, raw10000))
    val qsDTime = time(dq(qsD, raw10000))
    assert(ql.isEmpty)
    assert(qsD.isEmpty)
    assert(qlTime < qsDTime)
  }

}
