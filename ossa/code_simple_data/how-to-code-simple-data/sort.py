def insert(arr):
    l = len(arr)
    for i in range(l):
        for k in range(0, i):
            if arr[i] < arr[k]:
                arr[i], arr[k] = arr[k], arr[i]
    return arr

def bubble(arr):
    l = len(arr)-1
    for i in range(l):
        for k in range(l-i):
            if arr[k+1] < arr[k]:
                arr[k+1], arr[k] = arr[k], arr[K+1]
    return arr

p = [1,30,67,8,4,6,0,56]
print (insert(p))
print (bubble(p))
