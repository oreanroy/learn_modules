class Song(object):
	
	def __init__(self, lyrics):
		self.lyrics = lyrics
	
	def sing_me_a_song(self):
		for line in self.lyrics:
			print line
happy_bday = Song(["Happy birthday to you",
		  "I don't want to get sued",
		  "So I'll stop right here"])

bulls_on_parade = Song(["They rally around the family",
			"with pockets fall of shell"])

test = "This is just a test song"

test_song = Song(test)
test_song.sing_me_a_song()

happy_bday.sing_me_a_song()

bulls_on_parade.sing_me_a_song()
