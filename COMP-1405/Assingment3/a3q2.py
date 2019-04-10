#Student Name: Imran Juma
#Student Number: 101036672
#Assingment 3 Part 2
#Universe Numbers
#--------------------------------------



#--------------------------------------

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation

#Tutorial Citation 
#-------------------------------------

#Presenting The Numbers Between 0 and 9 That Are Divisible By 3 (3,6)
for q in range (0, 9, 3):

		#Presenting The Letters Between R and V However Not Inlcuding V (R,S,T,U)
	for w in range (ord('R'), ord ('V'), 1):

		#Presenting The Letters Between C and D However Not Inlcuding C 
		for e in range (ord('D'), ord ('E'), 1):

			#Presenting The Range Of The Value 4 to 5 But Only Presenting 4 
			for r in range (5, 6, 1):

				#Presenting Numbers Between 0 and 5, However Not The Number 5 (1,2,3,4)
				for t in range (0, 5, 1):

					#Presenting Numbers Between 0 and 9 That Are Divistable By 2 (2,4,6,8)
					for y in range (0, 9, 2):

						#This Insert Will Print All Of Our Values In The Order
						print (q, chr(w), chr(e), r, t, y)

#--------------------------------------
									#End Of Program