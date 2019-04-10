#Task1 
#Prime Number Detection 
# "%" is called Modulus, This meaning divisible 

UserNumber = int(input("Please Enter The Number     "))
print ("\n")


def PrimeNumber (UserNumber):
	for x in range (2, UserNumber):
		if UserNumber % x == 0:
			return False
			#print ("Your Number Is Not Prime")
	return True
	#print("Your number is prime")

print(PrimeNumber(UserNumber))