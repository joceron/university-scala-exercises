package com.lunatech.exercises.collections

/**
 * Elementary exercises on collections.
 * 
 * All these exercises can be solved with a single method invocation on 
 * the input list, from one of the following methods:
 * 
 * collect, drop, dropWhile, exists, filter, find, flatMap, flatten, 
 * fold, foldLeft, foldRight, forall, foreach, groupBy, headOption, 
 * length, map, partition, tail, take, takeWhile, toMap, zip
 */
object Part01 {
  
  /**
   * Example: Return the even numbers.
   */
  def exercise1(i: List[Int]) = 
    i.filter { _ % 2 == 0 }
  
  /**
   * Exercise: Return the first five numbers, or all numbers if there are less than five
   */
  def exercise2(i: List[Int]): List[Int] = 
    i.take(5)
  
  /**
   * Exercise: Return the list without the first five numbers
   */
  def exercise3(i: List[Int]): List[Int] = 
    i.drop(5)
  
  /**
   * Exercise: Return the square of all numbers
   */
  def exercise4(i: List[Int]): List[Int] = {
    i.map(i => i*i)
  }
  
  /**
   * Exercise: Return the product of all the numbers using a fold. Return 1 if the list is empty.
   */
  def exercise5(i: List[Int]): Int = {
    i.fold(1) { (a, b) => a * b}
  }
  
  /**
   * Exercise: Return the maximum of the parameter list,
   * and None when the parameter list is empty. 
   * Hint: Use `foldLeft` 
   */
  def exercise6(input: List[Int]): Option[Int] = {
    val result = input.foldLeft(0)((previous, actual) => if(actual > previous) actual else previous)
    if (result != 0) Some(result)
    else None
  }
  
  /**
   * Exercise: Return a tuple, where the first element contains all the input elements >= 10
   * and the second element contains all the input elements <= 10
   */
  def exercise7(input: List[Int]): (List[Int], List[Int]) = {
    input.partition(x => x >= 10)
  }
  
  /**
   * Exercise: Return a list of integers, where each input element is repeated it's own value times.
   * So input `List(1,3,2)` would give output `List(1,3,3,3,2,2)`. 
   * Hint: Use `List.fill` to create repeated lists as part of the solution. 
   */
  def exercise8(input: List[Int]): List[Int] = {
    input.flatMap(arg => List.fill(arg)(arg))
  }
  
  /**
   * Exercise: Return the even input elements squared, drop the other elements.
   */
  def exercise9(input: List[Int]): List[Int] = {
    input.collect {
      case x if x % 2 == 0 => x * x
    }
  }
}
