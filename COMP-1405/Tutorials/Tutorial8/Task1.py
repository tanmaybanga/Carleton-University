#Imran Juma
#SN: 101036672 
#Tutorial 7
#Task 1 


def isRectangular(matrix):
	length = len(matrix[0])
	for row in matrix:
		print(row)
		if length != len(row):
			return False 

	return True
	
#isRectangular()

