print ("\n")
print ("(A)ddition")
print ("(M)ultiplication")
print ("(S)ubtraction")
print ("(D)ivision\n")

Selection = input("Please Select A Function From The Above List\n")

if Selection == ("A"):
	print ("You Have Selected Addition From The above Function List\n")
	FirstValue = int(input("Please Enter Your First Value"))
	SecondValue = int(input("Please Enter Your Secton Value"))
	print ("Your Answer is", FirstValue + SecondValue)



elif Selection == ("M"):
	print ("You Have Selected Multiplcation From The above Function List\n")
	FirstValue = int(input("Please Enter Your First Value"))
	SecondValue = int(input("Please Enter Your Secton Value"))
	print ("Your Answer is", FirstValue * SecondValue)



elif Selection == ("S"):
	print ("You Have Selected Subtraction From The above Function List\n")
	FirstValue = int(input("Please Enter Your First Value"))
	SecondValue = int(input("Please Enter Your Secton Value"))
	print ("Your Answer is", FirstValue - SecondValue)



elif Selection == ("D"):
	print ("You Have Selected Division From The above Function List\n")
	FirstValue = int(input("Please Enter Your First Value"))
	SecondValue = int(input("Please Enter Your Secton Value"))
	print ("Your Answer is", FirstValue // SecondValue)

else:
	print("This was an Invalid Slection")