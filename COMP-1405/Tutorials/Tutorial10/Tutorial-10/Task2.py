#Tutorial 10 Task 2
#Student Number 101036672
#Produced By Imran Gabrani Juma 

#----------------------------Program begins----------------------------

from Task1 import *
from time import *
from random import *

User_Input_1 = int(input("Whats Your Range     "))
User_Input_2 = int(input("Whats Your Length     "))
User_Input_3 = int(input("How Many Test's Do You Want To Run     "))
list = [randint(1,User_Input_1) for i in range(User_Input_2)]
Total_Time_Taken = 0 

for i in range (User_Input_3):
	a = clock()
	InsterSortList(list)
	b = clock()
	time = b-a
	print(time)
	Total_Time_Taken = Total_Time_Taken + time 
print("Our Avrage Time Calculated Was ", Total_Time_Taken/User_Input_3)


#----------------------------Program Ends----------------------------
