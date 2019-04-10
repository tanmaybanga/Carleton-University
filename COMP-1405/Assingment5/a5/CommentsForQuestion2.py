#----------------------------------------------------------------------------#
'''
myfile = open("your-assigned-glyphs.dat", "r")
print (myfile.read())

~B%13  R%12  O%0  B%!3  J%_|  C%<  D%|)  C%(:   

'''
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
This Will Check If We Are In Placement 
Checking if we have a key in the desiered value
Returing A True or False Statement 
'''
def softwareReplacer(dictonary, keyword, value):
	if key in dictonary:
		dictonary[keyword][0]=value
		return True
	else:
		return False
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
Creating Another Function 
Again, Checking if they key is real 
Are we currently having an Old Key In The List
Replacing With the New Key 
Does The Old Key Exsist?
Replace It With the new key 
'''
def softwareUpdate(dictonary, keyword, oldVersion, newVersion):
	if keyword in dictonary:
		if dictonary[keyword][0]==oldVersion:
			dictonary[keyword][0]==newVersion
		elif dictonary[keyword][1]==oldVersion:
			dictonary[keyword][1]==newVersion
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
The first line includes the inital list that we where given in the "your-assigned-glyphs.dat" file 
as Noted At The Top 
This Now Includes the statments for what we are required to remove some elements from the sentance
This Now Inludes the elemtns that would strip the string 
This Now Inludes the elemtns that would split the string 
This Would Now also create our new diconary 
aswell this willl also create an exmpy list 
'''
givenSentence='~B%13#R%12#O%0#B%!3#J%_|#C%<#D%|)#C%(#:'
givenSentence=givenSentence.strip("~ :")
givenSentence=givenSentence.split("#")
dictonary={}
imranlist=[]
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
This section of the program begin our for loop list, then we will append and split some parts of the lsit
following this, we will be creating some varibles, if the varible is not already located in the diconary, othweise 
we will be append some of the values to the keywords 
''' 
for i in range(len(givenSentence)):
	imranlist.append(givenSentence[i].split('%'))
	keyword=imranlist[i][0]
	value=imranlist[i][-1]
	if not keyword in dictonary:
		dictonary[keyword]=([value])
		print(dictonary)

	else:
		dictonary[keyword].append(value)
		print(dictonary)

print(dictonary)
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
This Will Be Our Main Menu For The Program
'''
while True:
	programMenu=str(input("What Can We Do For You Today \nQuit The Program\nTranslate The Senteance\nUpdate The Sentance\nReplace The Sentance\n")).lower()
	if programMenu=='update':
	    keyword = str(input("Enter a key in the dictonary: "))
	    oldVersion = input("Enter the old value in the dictonary: ")
	    newVersion = input("Enter the new value in the dictonary: ")
	    softwareUpdate(dictonary,keyword,oldVersion, newVersion)
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
This section of the program will be doing all of our replacements 
    
	elif programMenu == 'replace':
		keyword=str(input("Enter a key in the dictonary: "))
		value=str(input("Enter a value for the dictonary: "))
		print(softwareReplacer(dictonary,keyword,value))  
#----------------------------------------------------------------------------#

'''

	
#----------------------------------------------------------------------------#
'''
This Section of the program will do all of our translating 
'''
	elif programMenu == 'translate':
	    strWord=''
	    word = str(input("Enter a phrase to translate: "))
	    for i in word:
	        if i in dictonary:
	            strWord+=(dictonary[i][0])
	       	else:
	       		strWord+=(i)
	    print(strWord,end='') 
	 
	elif programMenu=='quit':
		quit()
#----------------------------------------------------------------------------#




#----------------------------------------------------------------------------#
'''
***By Having An acess number of skip lines within the print "Invalid" Statement We are
Able to start fresh with A brand New Screen***

***I Found This To Make The Program Alot More "Clean"***

'''
	else:
		print("Unfortunaly You Have Entered An Ivalid Input, Would You Please Try Again")
		print ("\n")
		print ("\n")
		print ("\n")
		print ("\n")
		print ("\n")
#----------------------------------------------------------------------------#


