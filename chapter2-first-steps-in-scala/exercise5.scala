// Write a program that prints the numbers from 1 to 100. But for multiples of three print
// “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which
// are multiples of both three and five print “FizzBuzz”.
Range(1, 101).foreach(arg => {
	if (arg % 3 == 0 && arg % 5 == 0) print("FizzBuzz")
	else if (arg % 3 == 0) print("Fizz")
	else if (arg % 5 == 0) print("Buzz")
	else print(arg)
	println()
	})