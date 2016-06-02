// Like an array, you can also use a Range on the right hand side of an '<-' in a for-loop.
// Can you rewrite the previous program with a for-loop?
for (arg <- Range(1, 101)) {
	if (arg % 3 == 0 && arg % 5 == 0) print("FizzBuzz")
	else if (arg % 3 == 0) print("Fizz")
	else if (arg % 5 == 0) print("Buzz")
	else print(arg)
	println()
}
