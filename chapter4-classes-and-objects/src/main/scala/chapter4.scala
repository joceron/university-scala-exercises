

object chapter4 extends App {
  try {
    val a = args(0).toInt
    val b = args(1).toInt
    println(Math.sqrt(a * a + b * b).toInt)
  } catch {
    case e: Exception => println("Please, type two numbers as parameters")
  }
}