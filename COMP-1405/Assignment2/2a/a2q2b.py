#Imran Juma 101036672
#Assignment 2
#Question 2 Part 2
#Data Base Version 2
#-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 

#----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#
print ("\n")
print ("Welcome To Imran's Symbol Data Base")
#------------------- Introudction To Program
print ("\n")
print ("I Will Ask You Simple 'Yes' and 'No' Questions.")
print("This Program Will Efficently Identify Your Symbol")
print ("\n")

print ("\n")
print ("***Please Note To Disinguish Between Triangles And Arrows***")
print ("**First Letter Of The Answer MUST Be Capital**")
print ("\n")
#------------------- Program Begins 

#Spacing In The Program Helps Me See Better Sorry #SorryNotSorry...
print ("\n")
print ("\n")

#Asking The User What Direction The Arrow Will Point In
#This Will THen Make A Second Filter By The Number Of 
#Rectangles In The Symbol Provided
#Spacing Indicated After Each Result To Reduce Cluder

Direction = input("What Direction Does Your Arrow Point In **(Right, Left, Up, Down, or Circle**   ")
if Direction == "Right":
	Rectangle = input ("How Many Rectangles Does Your Symbol Have   ")
	if Rectangle == "2":
		print ("\n")
		print ("You Have Symbol 3")
		print ("\n")
	elif Rectangle == "0":
		print ("\n")
		print ("You Have Symbol 5")
		print ("\n")
	elif Rectangle == "1":
		print ("\n")
		print ("You Have Symbol 7")
		print ("\n")

#If The Arrows Direction Is Left This Will Filter
#This Will THen Make A Second Filter By The Number Of 
#Rectangles In The Symbol Provided
#Spacing Indicated After Each Result To Reduce Cluder
elif Direction == "Left":
	print ("\n")
	Rectangle = input ("How Many Rectangles Does Your Symbol Have   ")
	if Rectangle == "0":
		print ("You Have Symbol 8")

#If The Arrows Direction Is Up This Will Filter
#This Will THen Make A Second Filter By The Number Of 
#Rectangles In The Symbol Provided
#Spacing Indicated After Each Result To Reduce Cluder
elif Direction == "Up":
	print ("\n")
	Rectangle = input ("How Many Rectangles Does Your Symbol Have   ")
	if Rectangle == "0":
		print ("\n")
		print ("You Have Symbol 9")
		print ("\n")
	elif Rectangle == "3":
		print ("\n")
		print ("You Have Symbol 6")
		print ("\n")


#If The Arrows Direction Is Down This Will Filter
#This Will THen Make A Second Filter By The Number Of 
#Rectangles In The Symbol Provided
#Spacing Indicated After Each Result To Reduce Cluder
elif Direction == "Down":
	print ("\n")
	Rectangle = input ("How Many Rectangles Does Your Symbol Have   ")
	#Spacing After The Word Allows Me To Not Have Everything So Clumped Up
	if Rectangle == "0":
		print ("\n")
		print ("You Have Symbol 10")
		print ("\n")
	elif Rectangle == "2":
		print ("\n")
		print ("You Have Symbol 1")
		print ("\n")
	elif Rectangle == "3":
		print ("\n")
		print ("You have Symbol 4")
		print ("\n")

#EvenThough Circle Was Not A Direction, I Created A Seperate Filter
#I Found This To Be More Efficent and Less Confusion Within My Program
#Spacing Indicated After Each Result To Reduce Cluder
elif Direction == "Circle":
	print ("\n")
	print ("You Have Symbol 2")
	print ("\n")
	print ("\n")









