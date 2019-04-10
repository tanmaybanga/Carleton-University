#Sabina Bialic
#101029479
#citations
#Gaddis, T. (2015). "Starting Out With Python"
def myInt(m):
    #if m less than 6, this is the base case
    if m<6:
        #return the number at position m
        return[0,9,2,9,8,9][m]
    #if m is between 6 and 12 inclusive
    elif m>5 and m<12:
        #calculate and return the value at position m
        return myInt(m-6)-myInt(m-2)
    #for anything greater than 12
    else:
        #calculate and return the value at position m
        return myInt(m-4)//myInt(m-4)+myInt(m-6)
def myList(n):
    #if n less than 1
    if n<1:
        return[]
    #if n less than 6, this is the base case
    elif n<6:
        #split the list and return the list up to n
        return[0,9,2,9,8,9][:n+1]
#ask the user to input an int for the length of the sequence
n=int(input('How long should the sequence be? '))
#ask the user for which element they want to print
m=int(input('Which element of the sequence do you want to print? '))
#define a new empty list
x=[]
#call myList and print it
print(myList(n))
#call myInt and print it
print(myInt(m))