#Tutorial 10 Task 1 
#Student Number 101036672
#Produced By Imran Gabrani Juma 

#----------------------------Program begins----------------------------

def InsterSortList(list):
	
	for i in range(1,len(list),1):
		j = i
		while j > 0 and list[j] < list[j-1]:
			a = list[j]
			list[j] = list[j-1]
			list[j-1] = a 
			j = j-1
	
	return(list)

print(InsterSortList([1,0,3,8,9,4,5,1,2,9]))

#----------------------------Program Ends----------------------------
