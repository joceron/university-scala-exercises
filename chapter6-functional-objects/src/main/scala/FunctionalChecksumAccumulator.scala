object Exercises {
  /* In chapter 4 we encountered a class `ChecksumAccumulator`, defined like this:
   * 
   * class ChecksumAccumulator {
   *   private var sum = 0
   *   def add(b: Byte) { sum += b }
   *   def checksum(): Int = ~(sum & 0xFF) + 1
   * }
   *
   * This class is mutable.
   *
   * Exercise 1: Make a "functional object"-version of `ChecksumAccumulator`, called `FunctionalChecksumAccumulator`.
   */

  class FunctionalChecksumAccumulator {
    ???
  }

  /*
   * Exercise 2: Add a method `addString(s: String): FunctionalChecksumAccumulator`,
   * that adds add the bytes of a string. (Hint: You can get the bytes of a String
   * with the `getBytes` method.)
   *
   * Exercise 3: Using an implicit conversion, make it possible to directly call 'checksum' on
   * a String. So the following should compile:
   *
   * println("Everything is awesome!".checksum)
   * 
   */

}

