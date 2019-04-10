li = []

def CLAL():
	User_Add_Value = str(input("Would You Like To Add A Value To The List, Remove The Last Value Added, Or Exit The Loop?     "))

	if User_Add_Value == str("Add"):
		User_Inpit1 = int(input("What Value Would You Like To Add?    "))
		li.append(User_Inpit1)
		print(li)
		return CLAL()

	elif User_Add_Value == str("Remove"):
		li.pop()
		return CLAL()

	else:
		print("Bye!")
		

CLAL()