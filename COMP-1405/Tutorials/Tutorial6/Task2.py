#Task2
#Prime Number List 

UserNumber = int(input("Please Enter The Number     "))
print ("\n")

def PrimeNumber(UserNumber):
	return UserNumber % 3 ==0

for i in range (UserNumber):
	if PrimeNumber(i):
		print("*")
	else:
		print(i)

