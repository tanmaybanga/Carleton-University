#Imran Juma 101036672
#Assignment 2
#Question 1 Part 3
# Filter 5
#-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
	#Tutorial:3 User Age Calculation. (2016-09-26) Reterived from https://culearn.carleton.ca/moodle/pluginfile.php/1875694/mod_resource/content/10/Tutorial3Instructions.pdf

#----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#
#This Will Print The Introduction 
print ("\n")
print ("Welcome To Imran's Guess Who Round 3")
print ("**First Letter Of The Answer Must Be Capital**")
print ("\n")

#This Will Ask The First Question
Selection = input("Does Your Character Have a Beard\n")

#Answer To The First Question
if Selection == ("Yes"):
	print ("\n")
	print ("Congradulations You Have Narrowed It Down To The Final 5\n")
	print ("\n")

#The Follow up to the first Question	
Selection2 = input("Does Your Face With A Beard Have An Afro?\n")
if Selection2 == ("Yes"):
	print ("\n")
	print ("You Selected Last Face In The 3rd Row!, Congradulations You Win!")
	print ("\n")

#Responce To The User Saying No, an invalide Responce
elif Selection == ("No"):
	print ("Invalid Response")
	print ("\n")

#If the user enters a false responce, they will be given this message
else:
	print ("\n")
	print("Invalid Response GoodBye")
	print ("\n")
#----------------------------------------------------------------------Program Ends-------------------------------------------------------------------------#