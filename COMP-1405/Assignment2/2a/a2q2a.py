#Imran Juma 101036672
#Assignment 2
#Question 2 Part 1
#Data Base 1
#-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 

#------------------- Introudction To Program
print ("\n")
print ("Welcome To Imran's Symbol Data Base")
#------------------- Introudction To Program Information
print ("\n")
print ("I Will Ask You Simple 'Yes' and 'No' Questions.")
print("This Program Will Efficently Identify Your Symbol")
print ("\n")

print ("\n")
print ("***Please Note To Disinguish Between Triangles And Arrows***")
print ("**First Letter Of The Answer Must Be Capital**")
print ("\n")
#------------------- Program Begins 

#Question Pertaining To Symbols Characteristics
#These Where The Various Characteristics That Would Filter The Various Shapes 
ShapeSelection1 = input ("Does Your Symbol Make A Loop?   ")
ShapeSelection2 = input ("Does Your Symbol Point (Up)?   ")
ShapeSelection3 = input ("Does Your Symbol Point (Left)?   ")
ShapeSelection4 = input ("Does Your Symbol Point (Down)?   ")
ShapeSelection5 = input ("Does Your Symbol Point (Right)?   ")
ShapeSelection6 = input ("Does Your Symbol Have A Rectangle Attached To The Arrow?   ")
ShapeSelection99 = input ("Does Your Symbol Only Contain A Rectangle And Triangle   ")
ShapeSelection7 = input ("Does Your Symbol Have A 90 Degree Angle Pointing Down?   ")
ShapeSelection8 = input ("Does Your Symbol Contain Multiple Arrows?   ")
ShapeSelection9 = input ("Does Your Symbol Contain Multiple Turns With A Single Arrow?   ")

#Answers Linking Questions To Correct Symmbol
#Normally, The first "ShapeSelection" Will incicate the direction feautre
#Followed by the second Feature of the symbol
#However This Does Not Apply For Every Case

#Symbol-1-Answer
if ShapeSelection4 == "Yes" and ShapeSelection7 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 1")
	print ("\n")

#Symbol-2-Answer
elif ShapeSelection1 == "Yes" and ShapeSelection8 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 2")
	print ("\n")

#Symbol-3-Answer
elif ShapeSelection5 == "Yes" and ShapeSelection6 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 3")
	print ("\n")

#Symbol-4-Answer
elif ShapeSelection4 == "Yes" and ShapeSelection6 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 4")
	print ("\n")

#Symbol-5-Answer
elif ShapeSelection5 == "Yes" and ShapeSelection9 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 5")
	print ("\n")

#Symbol-6-Answer
elif ShapeSelection2 == "Yes" and ShapeSelection6 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 6")
	print ("\n")

#Symbol-7-Answer
elif ShapeSelection5 == "Yes" and ShapeSelection99 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 7")
	print ("\n")

#Symbol-8-Answer
elif ShapeSelection3 == "Yes" and ShapeSelection9 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 8")
	print ("\n")

#Symbol-9-Answer
elif ShapeSelection2 == "Yes" and ShapeSelection9 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 9")
	print ("\n")

#Symbol-10-Answer
elif ShapeSelection4 == "Yes" and ShapeSelection8 == "Yes":
	print ("\n")
	print ("Your Must Have Symbol 10")
	print ("\n")













