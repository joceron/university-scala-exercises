package com.lunatech.exercises.collections

import org.scalatest._

class Part01Spec extends FlatSpec with Matchers {
  import Part01._
  
  "Exercise 1" should "return the even numbers" in {
    exercise1(List(1,2,3,4,5,6)) shouldBe List(2,4,6)
    exercise1(List(1,3,5)) shouldBe empty
    exercise1(List.empty) shouldBe empty
  }

  "Exercise 2" should "return the first five numbers" in {
    exercise2(List(1,2,3,4,5,6,7,8,9)) shouldBe List(1,2,3,4,5)
    exercise2(List(1,2,3)) shouldBe List(1,2,3)
    exercise2(List.empty) shouldBe empty
  }
  
  "Exercise 3" should "return the list without the first five numbers" in {
    exercise3(List(1,2,3,4,5,6)) shouldBe List(6)
    exercise3(List(1,2,3,4,5,6,7,8,9,10,11,12)) shouldBe List(6,7,8,9,10,11,12)
    exercise3(List(1,2,3)) shouldBe empty
    exercise3(List.empty) shouldBe empty
  }
  
  "Exercise 4" should "return the square of all numnbers" in {
    exercise4(List(1,2,3)) shouldBe List(1,4,9)
    exercise4(List(-1)) shouldBe List(1)
    exercise4(List.empty) shouldBe empty
  }
  
  "Exercise 5" should "return the product" in {
    exercise5(List(1,1,1)) shouldBe 1
    exercise5(List(0,1,2,3)) shouldBe 0
    exercise5(List.empty) shouldBe 1
    exercise5(List(5,5,5)) shouldBe 125
  }
  
  "Exercise 6" should "return the max" in {
    exercise6(List(1,2,3)) shouldBe Some(3)
    exercise6(List(3,2,1)) shouldBe Some(3)
    exercise6(List(1,3,2)) shouldBe Some(3)
    exercise6(List.empty) shouldBe None
    exercise6(List(5,5,5)) shouldBe Some(5)
  }
  
  "Exercise 7" should "split a list" in {
    exercise7(List(1,2,3)) shouldBe (List.empty, List(1,2,3))
    exercise7(List(11,12,13)) shouldBe (List(11,12,13), List.empty)
    exercise7(List(9,10,11,12)) shouldBe (List(10, 11, 12), List(9))
    exercise7(List.empty) shouldBe (List.empty, List.empty)
  }
  
  "Exercise 8" should "expand a list" in {
    exercise8(List(1,2,3)) shouldBe List(1,2,2,3,3,3)
    exercise8(List(7)) shouldBe List(7,7,7,7,7,7,7)
    exercise8(List.empty) shouldBe empty
  }
  
  "Exercise 9" should "return even numbers squared" in {
    exercise9(List(1,2,3)) shouldBe List(4)
    exercise9(List(1,3,5)) shouldBe empty
    exercise9(List(1,2,3,4,5)) shouldBe List(4, 16)
  }
}
