class House:
	def __init__(self,win,flr,clr):
		self.__windows = win 
		self.__floors = flr
		self.__colour = clr

	def remodelHouse (self):
		self.__windows += 2 
		self.__floors += 1
		self.__colour = "turqise"
		print("This House Has Ben Remodeled")

	def getColour(self):
		return self.__colour
	
	def __str__(self):
		return("This is a house with {} floors, {} windows, coloured: {}") \
		.format(self.__floors, self.__windows, self.__windows)

#x = House (5,4, "Banana Yellow")
y = House(3,5,"Potato Brown")
