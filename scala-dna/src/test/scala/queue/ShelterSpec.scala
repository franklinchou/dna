package queue

import org.scalatest.FunSpec
import queue.shelter.{Cat, Dog, Shelter}

class ShelterSpec extends FunSpec {

  describe("Animal age") {
    it("should be appropriately tagged") {
      val d = new Dog
      val c = new Cat
      assert(d.age < c.age)
    }
  }


  describe("Shelter (from CTCI, 5ed., 3.7, p. 81)") {
    def build(): Shelter = {
      val s = Shelter.apply
      s.enqueue(new Dog)
      s.enqueue(new Cat)
      s.enqueue(new Dog)
      s
    }

    it("should support enqueue") {
      val s = build()
      assert(s.size == 3)
    }

    it("should support dequeue dog") {
      val s = build()
      s.dequeueDog
      assert(s.size == 2)
    }
    it("should support dequeue cat") {
      val s = build()
      s.dequeueCat
      assert(s.size == 2)
      assert(s.dequeueCat.isEmpty)
    }

    it("should support dequeue any") {
      val s = build()
      val d = s.dequeue
      val c = s.dequeue
      assert(s.size == 1)
      assert(d.get.isInstanceOf[Dog])
      assert(c.get.isInstanceOf[Cat])
    }

  }


}
