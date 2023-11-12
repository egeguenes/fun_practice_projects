# i guess its a brute force algorithm to sort the numbers from 0 to 2 in an array
def sort012(array , n):
	counter0 = 0
	counter1 = 0
	counter2 = 0
	for i in range(0,n):
		if array[i] == 0:
			counter0 += 1
		elif array[i] == 1:
			counter1 += 1
		else:
			counter2 += 1

	for i in range(0,n):
		if counter0 > 0:
			array[i] = 0
		else:
			if counter1 > 0:
				array[i] = 1
			else:
				array[i] = 2