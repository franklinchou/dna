package bag

import scala.collection.mutable
import scala.util.Random

class Bag[T] {

  /**
    * Using Queue instead of List here due to constant time `prepend` and `append`
    * characteristic of a Queue. In contrast, `append` to a List takes linear time.
    */
  private var data = mutable.Queue.empty[T]

  def add(item: T): Unit = {
    // Generate a random double between 0 and 1
    val random = Random.nextDouble()

    if (random > 0.5) {
      data = data += item
    } else {
      data = item +=: data
    }

  }

  def isEmpty: Boolean = data.isEmpty

  def size: Int = data.size

  def grab(): T = {
    val random = Random.nextInt(size)
    data.get(random) match {
      case Some(i) => i
    }
  }

}
