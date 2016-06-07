// Define the method makeThreeTuple so that the following code compiles:
def makeThreeTuple[Unknown](arg1: String, arg2: String, arg3: Unknown): (String, String, Unknown) = (arg1, arg2, arg3)

// Write your answer above this line and don't change the code below this line!
val allStrings = makeThreeTuple("foo", "bar", "buzzz")
val anInt = makeThreeTuple("foo", "bar", 42)
val aDouble: (String, String, Double) = makeThreeTuple("bon", "bini", 3.14159)
