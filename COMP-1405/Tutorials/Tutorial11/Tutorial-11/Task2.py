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
	def setName(self):
		Name = input("Input Name")
		self.name = Name
	def getName(self.name):
		return(self.name)
	def getType(self):
		return(self.type)
	def setType(self):
		Type = input("Input Type")
		self.type = type 
	def getAge(self):
		return (self.age)
	def getBill(self):
		return(self.bill)
