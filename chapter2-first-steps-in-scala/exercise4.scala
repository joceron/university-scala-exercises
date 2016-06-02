// Compute the sum of the uneven numbers from 1 to 100
var result = 0
Range(1, 101).foreach(arg => if (arg % 2 != 0) result += arg else result)
println(result)
