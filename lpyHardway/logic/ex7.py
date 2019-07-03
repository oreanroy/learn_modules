ten_things = "Apples Oranges Crows Telephone Light Sugar"

print "Wait there's not 10 thing in that list, lets fix that."

stuff = ten_things.split(" ")
more_stuff = ["Day", "Night", "song", "frisbee", "corn", "Banana", "Girl", "boy"]

while len(stuff) != 10:
	next_one = more_stuff.pop()
	print "Adding:", next_one
	stuff.append(next_one)
	print "There's %d items now." % len(stuff)

print "there we go: ", stuff

print "Let's do some things with stuff."

print stuff[1]
print stuff[-1]
print stuff.pop()
print ' '.join(stuff)
print '#'.join(stuff[3:5])


