from sys import argv

# take in the name of the file
script, filename = argv

# opens the fie
txt = open(filename)

# prints the filename
print "Here's your file %r:" % filename
# prints the contents of txt file
print txt.read()

print "Type the filename again:"

# take the file input again
file_again = raw_input("> ")

# open the file
txt_again = open(file_again)

# print what wass read
print txt_again.read()
