import random
from urllib import urlopen
import sys

WORD_URL = "http://learncodethehardway.org/words.txt"
WORDS = []

PHRASES = {
	"class %%%(%%%):":
	  "Make a class named %%% that is-a %%%.",
	"Class %%%(object):\n\tdef __init__(self, ***)":
	  "Class %%% has-a __init__ that tales self and *** parameters.",
	"Class %%%(object):\n\tdef ***(self, @@@)":
	  "Class %%% has-a function named *** that takes self and @@@ parameters.",
	"*** = %%%%()":
	  "Set *** to an instance of class %%%.",
	"***.***(@@@)":
	  "From *** get the *** fucntion, and call it with parameters self, @@@.",
	"***.***(@@@)":
	  "From *** get the *** function, and call it with parameters self, @@@.",
	"***.*** = '***'":
	"From *** get the *** attribute and set it to '***'."

# do they want to drill phrases first
PHRASE_FIRST = False
if len(sys.argv) == 2 and sys.argv[1] == 'english':
	PHRASE_FIRST = True

# load up the words form the website
for word in urlopen(WORD_URL).readlines():
	WORDS.append(word.strip())

def convert(snippet, phrase):
	class_names = [W.captilize() for w in
			random.sample(WORDS, snippet.count("%%%"))]
	other_names = random.sample(WORDS, snippet.count("***"))
	results = []
	param_names = []

	for i in range(0, snippet.count('@@@')):
		param_count = random.randit(1,3)
		param_names.append(', '.join(random.sample(WORDS, param_count)))
	
	for sentence in snippet, phrase:
		result = sentence[:]
	# fake class names

		for word in class_names:
			result = result.replace('%%%', word, 1)

		# fake other names
		for word in other_names:
			result = result.replace("***", word, 1)

		# fake paramter lists
		for word in param_names:
			result = result.replace("@@@", word, 1)
	
		results.append(result)

	return results
try:
	while True:
		snippets = PHRASES.keys()
		random.shuffle(snippets)

		for snippet in snippets:
			phrase = PHRASES[snippet]
			question, answer = convert(snippet, phrase)
			if PHRASE_FIRST:
				question, answer = answer, question
			print question
			
			raw_input("> ")
			print "ANSWER: %s\n\n" % answer
	except EOFError:
		print "\nBYe"
