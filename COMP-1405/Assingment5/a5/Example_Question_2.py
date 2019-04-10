#Sabina Bialic
#101029479

#citations
#Gaddis, T. (2015). "Starting Out With Python"

#create a new function
def myReplace(myDict, key, value):
    #check if key exists in dictionary
    if key in myDict:
        #change the value at that key
        myDict[key][0]=value
        #return True
        return True
    #otherwise
    else:
        #return false
        return False

#create a new function
def myUpdate(myDict, key, old, new):
    #check if key exists in dictionary
    if key in myDict:
        #if old exists in the dictionary at key[0]
        if myDict[key][0]==old:
            #replace it by new
            myDict[key][0]=new
        #if old exists in the dictionary at key[1]
        elif myDict[key][1]==old:
            #replace it by new
            myDict[key][1]=new

s='~I.1;R.12;E.3;G.cj;H.}{;B.|3;G.(_+;I.!;;'
#remove ~ and ;from the string
s=s.strip("~ ;")
#split the string at ;
s=s.split(";")
#create an empty dictionary
myDict={}
#create an empty list
myLi = []

#start a for loop
for i in range(len(s)):
    #append s[i] to myLi and split at every instance of .
    myLi.append(s[i].split('.'))
    #crreate a variable for the key
    key=myLi[i][0]
    #create a variable for the value
    value=myLi[i][1]
    #if the key is not already in the dictionary
    if not key in myDict:
        #set the key to the value
        myDict[key]=([value])
        print(myDict)
    #otherwise
    else:
        #append the value to the key
        myDict[key].append(value)
        print(myDict)

print(myDict)

#main program
#create a while loop
while True:
    #ask the user what they want to do
    menu=str(input("What Can We Do For You Today \nQuit The Program\nTranslate The Senteance\nUpdate The Sentance\nReplace The Sentance\n")).lower()
    #if update
    if menu=='update':
        #ask for a key
        key=str(input("Enter a key in the dictionary: "))
        #ask for an old value
        old=input("Enter the old value in the dictionary: ")
        #ask for a new value
        new=input("Enter the new value in the dictionary: ")
        #call the function
        myUpdate(myDict,key,old, new)

    #if replace
    elif menu=='replace':
        #ask for a key
        key=str(input("Enter a key in the dictionary: "))
        #ask for a value
        value=str(input("Enter a value for the dictionary: "))
        #call the function and print
        print(myReplace(myDict,key,value))

    #if translate
    elif menu=='translate':
        #create an empty string to store the translation of the word
        strWord=''
        #ask the user for a word
        word = str(input("Enter a phrase to translate: "))
        #start a for loop
        for i in word:
            #if the key is in myDict
            if i in myDict:
                #add the value at [i][0] to the word
                strWord+=(myDict[i][0])
            #otherwise
            else:
                #add i to the word
                strWord+=(i)
        #print the translation in one line
        print(strWord,end='')
        
    #if quit
    elif menu=='quit':
        #quit the program
        quit()

    #else
    else:
        #tell the user they entered an incorrect command
        print("The input you entered is incorrect. Please try again.\n")