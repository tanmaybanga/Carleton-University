#--------------------------------------
#Assingment 4 Project 2
#Asssingment Completed By Imran Gabrani Juma
# SN:101036672
#Completed for Dr. Robert Collier
#Quiz, Mutiple Choice // True and False
#--------------------------------------




#--------------------------------------
#Book Citation:
    #Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation
#--------------------------------------
#The Topics of Todays Quiz Will Pertain To Apple, and Apple Products 10 Multiple Choice and 5 True and False
# 5 True and False Questions & 10 Multiple Choice Questions 

Question_List ():
[
[1, "The Apple Pencil Only Works With The iPad Pro", 1, "(T)rue OR (F)alse?"], 
[2, "Apple Uses A Lunix Based Operating System", 2, "(T)rue OR (F)alse?"], 
[3, "You Must Have an iPhone to Use The Apple Watch", 3, "(T)rue OR (F)alse?"]
[4, "The iPhone 6S+ is Smaller Than The iPhone 6S", 4, "(T)rue OR (F)alse?"]
[5, "The iPhone 5S Is The Newest iPhone", 5, "(T)rue OR (F)alse?"]
[6, "Apple's Newest iPhone Colour is", 6, "Multiple Choice"]
[7, "What Is The Newest Colour For The 2016 Macbook Pro", 7, "Multiple Choice"]
[8, "Apple's Newest Macbook Pro Comes with What New Feature?", 8, "Multiple Choice"]
[9, "On Appe's iPad Pro, What Is The Base Model Storage Size", 9, "Multiple Choice"]
[10, "Appl's iPhone 6S and 7 Can Shoot In What Video Format", 10, "Multiple Choice"]
[11, "What Two Sizes Does The Apple Watch Come in", 11, "Multiple Choice"]
[12, "The Apple iMac Comes With What Size HDD", 12, "Multiple Choice"]
[13, "The Apple iMac Comes In What Two Sizes", 13, "Multiple Choice"]
[14, "What Colour Is Apples Mac Pro Computer (The Trash Can)", 14, "Multiple Choice"]
[15, "What Colour Is the Macbook Not Avalible In", 15, "Multiple Choice"]
]

Answer_List (): 
[
["True", "False" "", -1, True]
["True", "False" "", -1, True]
["True", "False" "", -1, True]
["True", "False" "", -1, False]
["True", "False" "", -1, False]
["Jet Black","Space Grey","Orange","Jet Blue",-1,0]
["Jet Black","Space Grey","Orange","Jet Blue",-1,1]
["Heavyer Computer","TouchBar","Smoke Machine","Nothing",-1,1]
["32GB, 16GB, 64GB, 128GB",-1,0]
["5K, 6K, 1080P, 4K",-1,3]
["38mm & 36mm","42mm and 55mm","38mm and 42mm" ,-1,3]
["500Gb", "1TB", "256GB",-1,0]
["21' and 27'","32' and 38'","40' and 42'"-1,0]
["Glossy Black","Silver", "Grey"-1,0]
["Red","Space Grey", "Gold"-1,0]
]

answers ()
print ()
print ("Lets see how well you've done on todays quiz")
print()
for i in range (len(Question_List):
	print(Question_List[i][0])
	if Question_List[i][2] == "MC":
		print ("a. " + Answer_List[i][0])
		print ("b. " + Answer_List[i][0])
		print ("c. " + Answer_List[i][0])
		userResponce == input()
		if userResponce == "a": #Stores User Answer
			Answer_List[i][3]=0 
		elif userResponce == "b": #Stores User Answer
			Answer_List[i][3]=1 
		elif userResponce == "c": #Stores User Answer
			Answer_List[i][3]=2 
		elif userResponce == "e": #Stores User Answer
			break
	elif Question_List [i][2] == "TF":
		print (Answer_List[i][0] + " or " + Answer_List[i][1])
		userResponce = input()
		if userResponce == "t" :
			Answer_List [i][3] = True
		elif userResponce == "f"
			Answer_List [i][3] = False
		elif userResponce == "e":
			break
		print()

for i in range(len(Answer_List)):
	if Answer_List[i][3] == Answer_List[i][4]:
		counter += 1
print ("Your SCore is " + str(counter) + " out of 15.")		




