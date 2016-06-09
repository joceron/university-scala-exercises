object Prime {

  /** Called at the beginning of the execution, to check if the input is correct */
  def checkInput(input: String): Int = {
    try {
      val goodInput = input.toInt
      if (goodInput < 2) throw new Exception("The number must be greater than 1")
      goodInput
    } catch {
      case nfe: NumberFormatException => throw new Exception("Wrong input. Please, enter an integer number.")
    }
  }

  /** Builds an array of booleans, not exceeding the input number. If 'true', the number is prime */
  def buildBoolArray(input: Int): Array[Boolean] = {
    // The size of the array has to be 'input+1' because it starts with 0 and not with 1
    val array = Array.fill[Boolean](input + 1)(true)

    val square = math.sqrt(input).toInt
    for (i <- 2 to square)
      if (array(i))
        for (j <- (i * i) to input by i)
          array(j) = false
    array
  }

  /** Transforms the array of booleans into a string to print */
  def formatBoolArray(array: Array[Boolean]): String = {
    val arrayIndex = array.zipWithIndex.drop(2)
    arrayIndex.filter { case (b: Boolean, i: Int) => b }.map { case (b: Boolean, i: Int) => i }.mkString(", ")
  }

  /** Main method */
  def calculatePrimes(arg: String): String = {
    try {
      formatBoolArray(buildBoolArray(checkInput(arg)))
    } catch {
      case e: Exception => e.getMessage
    }
  }

  def main(args: Array[String]) = {
    println(calculatePrimes(args(0)))
  }
}