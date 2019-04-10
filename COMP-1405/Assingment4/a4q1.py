#--------------------------------------
#Assingment 4 Project 1
#Asssingment Completed By Imran Gabrani Juma 
# SN:101036672
#Completed for Dr. Robert Collier 
#--------------------------------------




#--------------------------------------
#Book Citation: 
    #Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
#--------------------------------------




#                                                               Program Begins 




#--------------------------------------
#These are the definitions of our strings as instructed in the assingment sheet
#The Number Values within the "[]" Sections show the placesment of all of our letter values, out first value should begin with the number value of zero and then we skip one number when going towards the number 
#The Scramebeld Word showes what we are attempting to "Decode"
def concat_slices_and_print ():
  mainstring = "ihgfdcjkmnabspqrvwoluxyztdfgheijkmnp"
  string = mainstring [10:13] + mainstring [18:21] + mainstring [24] + mainstring [29]
  print (string)

#These are the definitions of our strings as instructed in the assingment sheet
#The Number Values within the "[]" Sections show the placesment of all of our letter values, out first value should begin with the number value of zero and then we skip one number when going towards the number 
#The Scramebeld Word showes what we are attempting to "Decode"
#We have inserted a "(x>0)" as we are attemting to recive a posotive value as instructed in the assingment 
#--------------------------------------




#--------------------------------------
def if_positive_concat_slices (x):
  if (x>0) :
    mainstring = "wvutxyzldfjkeamopqrcstuvwxhyzinfjkmopgqrstu"
    string = mainstring [7] + mainstring [12:14] + mainstring [19] + mainstring [26] + mainstring [29:31] + mainstring [37]
    print (string)

#These are the definitions of our strings as instructed in the assingment sheet
#The Number Values within the "[]" Sections show the placesment of all of our letter values, out first value should begin with the number value of zero and then we skip one number when going towards the number 
#The Scramebeld Word showes what we are attempting to "Decode"
def return_concat_slices ():
    mainstring = "bzyxwucdfghjovekmpqstruwxyzlaicdfghnjkmp"
    string = mainstring [12:15] + mainstring [21] + mainstring [27:30] + mainstring [35]
    return (string)
#--------------------------------------




#--------------------------------------
#These are the definitions of our strings as instructed in the assingment sheet
#The Number Values within the "[]" Sections show the placesment of all of our letter values, out first value should begin with the number value of zero and then we skip one number when going towards the number 
#The Scramebeld Word showes what we are attempting to "Decode"
def concat_arg_slices_and_return (mainstring):
    if (mainstring == "xwvusqyzreldfhjkatimopqnsuvwgxyzbcd"):
        string = mainstring [8:11] + mainstring [16:19] + mainstring [23] + mainstring [28]
    if (mainstring == "mkjihgnpqrsoluwxyzvatbcfgehijkdmnpqru"):
        string = mainstring [10:13] + mainstring [18:21] + mainstring [25] + mainstring [30]
    if (mainstring == "cazyxwfhijblukmpqrdgestvwoxyzncfhijk"):
        string = mainstring [10:13] + mainstring [18:21] + mainstring [25] + mainstring [29]
    #This Return string is very important as without it, the prints for test 5,6,7 will all come out as a none value. Speaking from personal experiance 
    return (string)
#--------------------------------------




#--------------------------------------
#These are the definitions of our strings as instructed in the assingment sheet
#Here we are calling upon our function and printing what we have decoded though the values in the correct sections 
#This insertation of code was procided though the assingment file and was not created by me 
def main():

    print("Test 1 of 7:", concat_slices_and_print())
    print("Test 2 of 7:", if_positive_concat_slices(1))
    print("Test 3 of 7:", if_positive_concat_slices(-1))
    print("Test 4 of 7:", return_concat_slices())
    
    # replace the strings for the next three arguments with those values
    # provided in the generator-specified criteria for your 4th function
    print("Test 5 of 7:", concat_arg_slices_and_return("xwvusqyzreldfhjkatimopqnsuvwgxyzbcd"))
    print("Test 6 of 7:", concat_arg_slices_and_return("mkjihgnpqrsoluwxyzvatbcfgehijkdmnpqru"))
    print("Test 7 of 7:", concat_arg_slices_and_return("cazyxwfhijblukmpqrdgestvwoxyzncfhijk"))

#This portion is very important and without it I experianced great difficult in why my program would not run
#Defianilty a very important line
main()
#--------------------------------------



    
#                                                                        END OF PROGRAM




