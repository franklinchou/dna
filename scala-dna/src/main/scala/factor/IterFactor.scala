import scala.collection.mutable.{Map => MMap}
import scala.util.control.Breaks._

/**
 * Given a list [a, b, a, b]
 * Determine the occurences of each item in the list, e.g., 
 * [a = 2, b = 2]
 */
def list2occurrences(l: List[String]): Map[Char, Int] =
  l.flatMap(_.toList).groupBy(identity).view.mapValues(_.size).toMap
  
def deduce(m: Map[Char, Int]): MMap[Char, Int] = {
  val totalInputSize = m.values.sum * m.size
  var result: MMap[Char, Int] = MMap()
  var i = 2
  for ((k, v) <- m) {
    breakable {
      while (i < 9999) {
        if (totalInputSize % i == 0) {
          result = result + (k -> i) // this is deprecated
          break()
        }
        i = i + 1
      }
    }
    i = i + 1
  }
  result
}


// Test
val t1 = List("a", "b", "a", "c", "ab", "a", "b", "ac")
val t1Converted = list2occurrences(t1)
val t1Result = deduce(t1Converted)

