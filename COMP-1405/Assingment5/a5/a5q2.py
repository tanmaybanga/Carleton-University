#--------------------------------------
#Assingment 5 Project 2
#Asssingment Completed By Imran Gabrani Juma 
#SN:101036672
#Completed for Dr. Robert Collier 
#--------------------------------------




#--------------------------------------
#Book Citation: 
#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
#--------------------------------------


#----------------------------------------------------------------------------#

myfile = open("your-assigned-glyphs.dat")
givenSentence = myfile.read()
myfile=myfile.close()
#----------------------------------------------------------------------------#
'''
	* This Will Be our primary function 
	* Working with our True Statement  
	* Working with our False Statement  
'''
def myReplace(dictonary, keyword, value):
	if keyword in dictonary:
		dictonary[keyword][0]=value
		return True
	else:
		return False
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
def mySize(dictonary, keyword,):
	
	'''
	* Creating the give stentance
	* Providing the senteance that was given to us in the assingment
	* Creating our diconary 
	* Creating our inistal list
	'''

givenSentence=givenSentence.strip("~ :")
givenSentence=givenSentence.split("#")
dictonary={}
imranlist=[]
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
'''
	* Creating the Append function for the user
'''
for i in range(len(givenSentence)):
	imranlist.append(givenSentence[i].split('%'))
	keyword=imranlist[i][0]
	value=imranlist[i][-1]
	if not keyword in dictonary:
		dictonary[keyword]=([value])

	else:
		dictonary[keyword].append(value)
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
	'''
	* This Offers our main menu to the user 
	'''
while True:
	programMenu=str(input("Here Are The Basic Services My Software Offers \nTranslate A Given Sentance \nGiven The Size \nQuit The Program \nReplace The Given Sentance\n")).lower()
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
	'''
	* This function will print the size of the list that has been created 
	'''
	if programMenu=='size':
		counter = 0
		for x in dictonary:
			toadd = len(dictonary[x])
			counter = counter + toadd
		print(counter)
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#    
	elif programMenu == 'replace':
		keyword=str(input("Please Enter A Valid Keyword For Our Dictonary: "))
		value=str(input("Please Enter A Valid Value For Our Dictonary: "))
		print(myReplace(dictonary,keyword,value))  
		'''
	* This is our replace function that can replace majorkey words 
	* Within the program
	'''
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
	
	elif programMenu == 'translate':
	    string_Main_Word=''
	    phrase = str(input("Please Enter What You Would Like To Translate: "))
	    for i in phrase:
	        if i in dictonary:
	            string_Main_Word+=(dictonary[i][0])
	       	else:
	       		string_Main_Word+=(i)
	    print(string_Main_Word,end='') 
	    '''
	* This function will translate our given function, and ask the user what
	* They would like to translate specfically
	'''
#----------------------------------------------------------------------------#


#----------------------------------------------------------------------------#
	
	elif programMenu=='quit':
		quit()
		'''
	* This function will use our quit program in conjunction with .lower() 
	'''
#----------------------------------------------------------------------------#

#----------------------------------------------------------------------------#
	
	else:
		print("Unfortunaly You Have Entered An Ivalid Input, Would You Please Try Again")
		print ("\n")
		print ("\n")
		print ("\n")
		print ("\n")
		print ("\n")
		'''
	* This function will print our invalid input statement 
	'''
#----------------------------------------------------------------------------#



