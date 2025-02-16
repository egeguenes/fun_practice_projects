# takes an array and a number as instance and checks the sum of the elements, accordingly finds out which element from zero to n isnt in the array
def missingElementSolution(array , n):
	nSum = (n * (n+1)) / 2
	arraySum = 0
	for i in range(0,len(array)):
		arraySum += array[i]
	return nSum - arraySum