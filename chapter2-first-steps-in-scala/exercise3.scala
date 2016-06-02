// With Range(1,10) you can create a collection containing the numbers 1 to 10 (exclusive).
// For many purposes, this behaves like an Array. Use this and 'foreach' to rewrite the
// previous program
// This eliminates the need for an iterator variable and also the chance of
// an off-by-one error that could cause an out of bounds array access.
var result = 0
Range(1, 10).foreach(arg => result += arg)
println(result)