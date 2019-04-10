class Pet:
	def __init__(self, name, type, age, bill):
		self.name = name
		self.type = type
		self.age = age 
		self.bill = bill 

	def growOlder(self):
		self.age += 1 
	def addToBill(self, spent):
		self.bill += spent

Name = input(" \n \n \n \nPlease Type In The Name Of Your Pet    \n ") 
Type = input("Please Type In The Type Of Pet You Have  \n   ")
Age = int(input("Please Type In The Age Of Your Pet    \n "))
Bill = 0

x = Pet(Name, Type, Age, Bill)
while True: 
	spent = input ("How Much Did You Spend On Your Pet This Year? \nIf Unsure Please Please Enter 'Quit' To Exit the Program     ")
	if spent == 'Quit': 
		break 
	if spent == 'quit':
		break 
	else:
		x.growOlder()
		x.addToBill(int(spent))
		print(" \n \n \n \nYour Animal's Name Is {} \nHe/She Is A {} \nWho Is {} Years Old. \n \nThe Total Bill For Your Pet This Year is {}".format (x.name, x.type, x.age, x.bill))