import org.scalatest.FunSuite

class Test extends FunSuite {
  test("Standard input") {
    val output = Prime.calculatePrimes("25")
    assert(output == "2, 3, 5, 7, 11, 13, 17, 19, 23")
  }

  test("String input") {
    val output = Prime.calculatePrimes("asdf")
    assert(output == "Wrong input. Please, enter an integer number.")
  }

  test("Less or equal to 1 input") {
    val output = Prime.calculatePrimes("1")
    assert(output == "The number must be greater than 1")
  }

  test("Smaller number") {
    val output = Prime.calculatePrimes("2")
    assert(output == "2")
  }

  test("The input number is prime") {
    val output = Prime.calculatePrimes("7")
    assert(output == "2, 3, 5, 7")
  }
}