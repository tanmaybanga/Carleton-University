# This Will Save Our Input Varibles 
FirstName = input("Please Enter Your First Name ")
YearBorn = int(input("Please Enter Your Year Born "))

#Taking The Sum Of Current Year - YearBord
#Creating the "Inbetween Age"

Sum1 = (2016 - YearBorn)
Sum2 = Sum1 - 1 

#Printing Our Final Values
print ("Your Name Is", FirstName, "Your Current Age Is Between", Sum1, "And", Sum2)