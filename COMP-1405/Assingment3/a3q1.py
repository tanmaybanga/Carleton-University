#Student Name: Imran Juma
#Student Number: 101036672
#Assingment 3 Part 1 
#Maze Finder 
#--------------------------------------



#--------------------------------------

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
#--------------------------------------




#Within My Program I have created it such that 
#The "For Loop" Will Indicate For The Up and Down Direction
#Within The Same Context The "While Loops" Will Be Used For The Left & Right Direction

#--------------------------------------

#This Will Import Our Functions From The Provided Library 
from helper import *

#--------------------------------------


#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program
for x in range (1):
	goDown()
 
#This Will Allow For The Maze To Go Right With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goRight" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0

while (y < 2):
	goRight()
	y = y + 1 

#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program
for x in range (3):
	goDown()

#This Will Allow For The Maze To Go Left With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goLeft" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0
while (y < 2):
	goLeft()
	y = y + 1 

#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program

for x in range (1):
	goDown()

#This Will Allow For The Maze To Go Left With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goLeft" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0
while (y < 1):
	goLeft()
	y = y + 1

#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program
for x in range (3):
	goDown()

#This Will Allow For The Maze To Go Left With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goLeft" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0
while (y < 1):
	goLeft()
	y = y + 1

#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program

for x in range (1):
	goDown()

#This Will Allow For The Maze To Go Right With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goRight" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0
while (y < 12):
	goRight()
	y = y + 1 

#This Will Allow For The Maze To Go Down With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goDown" We Are Using A "For Loop" As Stated Initialy In Our Program
for x in range (2):
	goDown()

#This Will Allow For The Maze To Go Left With The Value Indicated In (x) Value
#Because We Are Going In The Direction Of "goLeft" We Are Using A "While Loop" As Stated Initialy In Our Program
y = 0
while (y < 1):
	goLeft()
	y = y + 1 
#--------------------------------------
#These Are Our Ending Statements That Will Aloow For The Program To Know Once The Task Has Been Completed
#This is done by using both "True" and "False" Statements
#Here We Also Used Our Varible To Be Called "Completed" That Would Allow For The "True" and "False" Statements To Work Together


#--------------------------------------
Completed = False 
while not Completed:
	goDown()
	goDown()
	goDown()
	Completed = True
#--------------------------------------

#--------------------------------------
#These Are Our Ending Statements That Will Aloow For The Program To Know Once The Task Has Been Completed
#This is done by using both "True" and "False" Statements
#This Also Works Hand In Hand With The "Break" Function
while True: 
	goRight()
	break
#--------------------------------------
