import copy as cop

l1 = [1, 2, 3, 4]

# soft copy
l2 = cop.copy(l1)

# deep copy

l3 = cop.deepcopy(l1)

print (l2)
print (l3)

print ("The effect of soft copy")
l1[1] = 8
print("this is l1 after l2's alternation ")
print(l1)
print("this is l2 after alternaion")
print(l2)

print("The effect of hard copy")

l1[2] = 8
print("This is l1 after l3 was latered")
print(l1)
print("The altered  l3")
print(l3)

