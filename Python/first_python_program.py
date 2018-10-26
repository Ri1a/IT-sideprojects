#This is my first python program


variable = "variable"

def doSomething():

	print "This is a %s and an output" % variable

def doMath(a, b):

	number = a + b
	print "The number %d is the number of the function doMath" % number
	return number

def anotherFunction(do, what):
	print do + what

doSomething()
doMath(2, 5)
anotherFunction("What am I supposed to do?", " Just learning python!")