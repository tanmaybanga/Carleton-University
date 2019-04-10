
print ("Please Enter An Amount Of Days ")

Days = int(input("How Many Days: "))

Year = Days//365
Remainder1 = Days%365

Months = Remainder1//30
Remainder2 = Remainder1 - (30 * Months)

Weeks = Remainder2//7
Remainder3 = Remainder2 - (7 * Weeks)

Days = Remainder3//1
Remainder4 = Remainder3 - (1 * Days)

print ("Your Amount Of Days Is ")

print (Year, "Years", Months, "Months", Weeks, "Weeks", Days, "Days", )

#print(Remainder1)
#Testing Reamined

#print(Months, "Months")
#print(Remainder2)
#Testing Reamined

#print(Weeks, "Weeks")
#print(Remainder3)
#Testing Reamined

#print(Days, "Days")
#print(Remainder4)
#Testing Reamined
