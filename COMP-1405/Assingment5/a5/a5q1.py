#Assingment 5 Project 1
#Asssingment Completed By Imran Gabrani Juma
# SN:101036672
#Completed for Dr. Robert Collier
#Output Printer

#--------------------------------------
#Book Citation: 
    #Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
#--------------------------------------

#----------------------------------------------------------------------------#
'''
* This is my orgiginal Function, Named Return One Begin Our First Input 
* MyList Reffers To The first list that I have created that includes the orginial values 
That I have Recived from The Asingmnet generator 
* Returning Our List 
* Listing the range between the list 
* Setting the values to euqal a specific amount if between a specific peramitor
* Returing the function 
'''
#----------------------------------------------------------------------------#




#-------------------------------------Program Begins------------------------#

#----------------------------------------------------------------------------#
def returnOne(n):
	myList1 = [0,1,3,0,6,7]
	if n <= 5 and n >= 0:
		return myList1[n]

	#if between 6 and 10 return the function
	elif n > 5 and n < 11:
		if returnOne (n-3) != 0:
			return (returnOne(n-3) % returnOne(n-3))
		else:
			return (0)
	#else return function
	else:
		return(returnOne(n-4) * (returnOne(n-7) - returnOne(n-7)))
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
* This will be our second function, and similiary foloowing some of the same poramitors 
* Returning and appending based on the value impoted specfically by the user 
* Appending and returning the list
'''
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
def returnTwo(n):
	list = []

	if n==0:
		return([])
	
	elif n<6:
        
		return([0,1,3,0,6,7][:n+1])
		if list [n-3] != 0:
			list.append (list[n-3] % list[n-3])
		else:
			list.append (0)
	#else return function
	
	elif 11 >= n: 
		list.append (list[n-4] * (list[n-7] - list[n-7]))

	return list
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
* User input
* Printing the user input 
* User input again 
* Printing again
'''
#----------------------------------------------------------------------------#



#----------------------------------------------------------------------------#
n = int(input("How Long Do You Want The List    "))
print (returnTwo(n))

n = int(input("What Value Do you Want To Print    "))
print (returnOne(n))
#----------------------------------------------------------------------------#
