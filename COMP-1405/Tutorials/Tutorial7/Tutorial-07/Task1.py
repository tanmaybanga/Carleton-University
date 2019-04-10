inputUserInteger = int(input("What Posotive Intenger Would You Like    "))
li = []

for x in range(inputUserInteger):
	li.append(x)

for y in range(inputUserInteger):
	li.append(-1)
	li.remove(y)
print("\n")
print (li) 

for z in range(inputUserInteger):
	print("\n")
	inputIndexChanger = int(input(
		"From The Value Index,  Would You Like To Change       "))
	li.append(inputIndexChanger)
	li.remove(-1)

print(li)
