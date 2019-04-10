#Imran Juma 101036672
#Assignment 1.2
#Conversion Calcuator
#-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
	#Tutorial:3 User Age Calculation. (2016-09-26) Reterived from https://culearn.carleton.ca/moodle/pluginfile.php/1875694/mod_resource/content/10/Tutorial3Instructions.pdf

#----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#

#These Are the conversion calcuations that we where given though the random Generator 

Kilderkin = 0.081830 
Sack = 0.109106

#Skip A Line Function
print ("\n")

#This is the amount that the user would like to convert
UserInput = float (input ("How Many Would You Like To Convert\n"))

#When planning this was the equation that I came up with to convert my values 
Equation1 = UserInput * Kilderkin / Sack 
Equation2 = UserInput * Sack / Kilderkin 

#This will print the function for how many items where converted 
print ("You Have ", Equation1, "Kilderkin In Sacks")
print ("You Have ", Equation2, "Sacks In Kilderkin")

#----------------------------------------------------------------------End OF Program-------------------------------------------------------------------------#
