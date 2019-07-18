from sys import exit
from random import randint


class Scene(object):
	def enter(self):
		print "This scene is not yet configured. Subclass it and implement enter()."
		exit(1)
	
class Engine(object):
	def __init__(self, scene_map):
		self.scene_map = scene_map
	def play(self):
		current_scene = self.scene_map.opening_scene()
		
		while True:
			print "\n--------"
			next_scene_name = current_scene.enter()
			current_scene = self.scene_map.next_scene(next_scene_name)
class Death(Scene):
	
	quips = [
		"you died. You kindda suck at this.",
		"Your mom would be proud.. if she were smarter.",
		"Such a luser.",
		"I have a small puppy that's better at this."
	]

	def enter(self):
		print Death.quips[randint(0, len(self.quips)-1)]
		exit(1)

class CentralCorridor(Scene):
	
	def enter(self):
		print "The Gothons of Planet Percal #25 have invaded your ship and destroyed"
		print "Your entire crew. You are the last surviving member of your last"
		print "mission is to get the neutron destruct bomb from weapons Armory"
		print "Put it in the bridge, and blow the ship up after getting into an"
		print "escape pod."
		print "\n"
		print "You're running down the central corridor to the weapons Armory when"
		print "a Gothon jumps out, red scaly skin, dark grey, he's blocking the door to the"
		print "Armory and about to pull a weapon to balst you"
		
		action = raw_input("> ")
		if action == "shoot!":
			print "Quick on the draw you yank out your balster and fire it at the Gothon."
			print "His clown costume is flowing and moving around his body, which thows"
			print "Off your aim. Your laser hits his costume but misses him entirely. This"
			print "makes him fly into a rage and blast you repeteadly in the face until"
			print "You are dead. Then he eats you."
			return 'death'

		elif action == "dodge!":
			print "Like a world class boxer you dodge, weave, slip and slide right"
			print "as the Gothon's blaster cranks a laser past your head"
			print "In the middle of your artful dodge your foot slips and you"
			print "bang your head on the metal wall and pass out."
			print "You wake up shortly after only to die as the Gothon stomps on"
			print "Your head and eats you."
			return 'death'

		elif action == "tell a joke":
			print "Lucky for you they made you learn Gothom insults in the academy."
			print "You tell the one Gothon joke you know:"
			print "Lbhe zbgrue vf fb sng, jura fur , fur gur ubhfr."
			print "The Gothon stops, tries not to laugh, then busts out laughing and can't move."

			print "while he is laughing you run up and shoot him square in the head"
			print "putting him down, then jump through the weaopon Armory door."
			return 'laser_weapon_armory'
		
		else:
			print 'DOES NOT COMPUTE!'
			return 'central_corridor'

class LaserWeaponArmory(Scene):

	def enter(self):
		print "You do a dive roll into the weapon Armory, crouch and scan the room"	
		print "for more Gothons that might be hidding. It's dead quiet, too quiet."
		print "You stand up and run to the far side of the room and find the"
		print "neutron bomb in its container. There's a keypad lock on the box"
		print "and you need the code to get the bomb out. If you get the code"
		print "Wrong 10 times then the lock closes forever and you can't"
		print "get the bomb. the code is three digits"
	
		code = "%d%d%d" % (randint(1,9), randit(1,9), randit(1,9))
		guess = raw_input("[keypad]> ")
		guesses = 0
		while guess != code and guesses < 10:
			print "BZZZZEDD!"
			gusses += 1
			guess = raw_input("[keypad]> ")
	
		if guess == code:
			print "The container clicks open and the seal breaksm, letting gas out."
			print "You grab the neutron bomb and run as fast as you can to the"
			print "bridge where you must place it in the right spot."
			return 'the_bridge'
		else:
			print "The lock buzzes one last time and then you hear a sickeing"
			print "melting sound as the mechaism is fused together."	
			print "You decide to sit there, and finaly the gothoms blow up the"
			print " ship from their ship you die."
			return 'death'
	
class TheBridge(scene):
	
	def enter(self):
		print "You burst into the bridge with neutron destruct bomb"
		print "under your arm and surprise 5 gothoms who are trying to"
		print "Take control of the ship. Each of them has a even uglier"
		print "Clown costume than the last. They haven't pulled their"	
		print "Weapons out yet, as they see the active bomb under your"
		print "arm and don't want to set it off."	

		action = raw_input("> ")
		
		if action == "throw the bomb":
			print "In a panic you throw the bomb at the group of Gothons"
			print "and make a leap for the door. RIght as you drop it a"
			print "Gothom shoots you right in the back killing you"				print "as you die see another Gothon Frantically try to disarm"
			print "the bomb. You die knowing they will probaly blow up when"
			print "It goes off."
			return 'death'
		
		elif action == "Slowly place the bomb":
			print "You point your blaster at the bomb under your arm"
			print "and the gothoms put their hands up and start to sweat"
			print "you inch backward to the door, open it, and then carefully"
			print "place the bomb on the floor, pointing your blaster at it"
			print " You then jump back through the door, punch the close button"
			print "and blast the lock so the Gothons can't get out."	
			print "get off this tin can"
			return 'escape_pod'
		else:
			print "DOES NOT COMPUTE!"
			return "the_bridge"

class EscapePod(Scene):
	
	def enter(self):
		print "You rush through the ship desperately trying to make it to"
		print "the escape pod before the whole ship eplodes. It seems like"
		print "hardly any Gothons are on the ship. so your run is clear of"	
		print "interferance. You get to the chamber with the escape pods and"
		print "now need to pick one to take. Some of them could be damaged"	
		print "But you don't have time to look. There's podsm which one"
		print "do you take?"
		
		good_pod = randint(1,5)
		guess = raw_input("[pod #]> ")
		
		if int(guess) != good_pod:
			print "You jump into pod %s and hit the eject button." % guess
			print " The pod escapes out into the void of space, then"
			print " back and see your ship implode then explode like a "
			print "bright star, taking out the gothon ship at the same"
			print "time. You won!"
			return 'finished'

class Map(object):
	
	scenes = [
		'central_corridor': CentralCorridor(),
		'laser_weapon_armory': LaserWeaponArmory(),
		'the_bridge': TheBridge(),
		'escape_pod': EscapePod(),
		'death': Death()
	]
	
	def __init__(self, start_scene):
		self.start_scene = start_scene

	def next_scene(self, scene_name):
		return Map.scenes.get(scene_name)

	def opening_scene(self):
		return self.next_scene(self.start_scene)

	
a_map = Map('Central_corridor')
a_game = Engine(a_map)
a_game.play()
