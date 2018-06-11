package queue.shelter

trait Animal {

  /**
    * Since we're using `nanoTime`, a larger time is actually MORE recent.
    * The Instant library does not have the requisite level of precision.
    *
    */
  val age: Long = System.nanoTime()

}