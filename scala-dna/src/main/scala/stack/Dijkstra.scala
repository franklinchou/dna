package stack

import scala.util.Try


/**
  * Use Dijkstra's two stack algorithm for expression evaluation, p. 130.
  */
object Dijkstra {

  private def tryNumber(s: String) = Try(s.toDouble).toOption

  private def accepted: Set[String] = Set("+", "-", "/", "*", "sqrt")

  def apply(input: String): Double = {

    var in = utils.File.read(input).toStream

    val operators = new StackArray[String]
    val values = new StackArray[Double]


    while (in.nonEmpty) {

      val line = in.head.trim

      val isInt = tryNumber(line).isDefined

      if (isInt) {
        values.push(line.toInt)
      } else if (accepted contains line) {
        operators.push(line)
      } else if (line == ")") {
        val op = operators.pop()
        if (op == "sqrt") {
          values.push(Math.sqrt(values.pop()))
        } else {
          val a = values.pop()
          val b = values.pop()
          op match {
            case "+" => values.push(a + b)
            case "-" => values.push(b - a)
            case "*" => values.push(a * b)
            case "/" => values.push(b / a)
          }
        }
      } else {
        // Do nothing
      }

      in = in.drop(1)
    }
    values.pop()
  }




}
