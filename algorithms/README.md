
## RAFT Consensus Algorithm
	>>Leader election
		--select one server to act as leader
		--Detect crashes, choose new leader
	>>Log replication
		--Leader accepts commmands from client, appends
		  to its log
		-- Leader replicates its log to other servers(overwrites inconsistencies)
	>>Safey
		-- keeps logs consistent
		-- Only servers with up-to-date logs can become leader

	
	The server can remain in three different states that is
		-- Follower
		-- candidate
		-- Leader
 
	Leader is the one which everyone follows
		> A leader is selected when one of the server 
		  times out 
		> A leader is also selected if the present leader
		  dies
			### The way to select a leader
			the cadidate which timed out sends
			a signal to all servers for polling 
			if it aquires enough votes it is selected
			as the leader or another one sends a polling 
			request.
			
			### There are ways to make sure two different 
			servers are not selected as leader at the same
			time. One of the ways is to select the one which 
			has most updated terms and logs

			### Another way is to count number of votes
			
			### A leader needs to keep on sending heart beat
			signals to other nodes to maintain its superamacy

	### Log manipulation in the leaders logs 
		The client sends the requets to leader and then the leader
		broadcasts it all the servers if the ample number of followers 
		make a entry in their logs. The leader commits it into its own log
		a log entry genrally consists of three information
		command(specified by client to execute)
		index(to identify the position of entry in the log)
		Term Number( to asertain time of entry of command)

	### Log inconcentancy maintainance
		
		if there is a inconcentancy in the log of the follower
		the leader sends past records along with the new uptill 
		the point where the logs start to match. If the follower 
		has a log with latest term it is appointed as the leader


## C3 Linearization Alorithm also C3 method reoslution oder


	This algorithm is of easy complexity and used to resolve the mro in pyhton3 		inheritance of mutliple classes
	
	The linearization of c is the sum of c plus the merge of linearizations
	of the parents and list of parents

	> take the head of the first list
	> if this head is not in tail of any of the other lists, then add it to the 		linearization of c and remove it from the lists in the merge
	> other wise look at the head of next list and take it, if is a good head
	> Then repeat the operation until all the class are removed or it is 
	impossible to find good heads.

	L[C(B1...BN)] = C + merge(l[B1]...l[BN], B1..BN)


	consider an example 
	o = object
	class F(O): pass                           O
	class E(O): pass                          /|\
	class D(O): pass                         / | \
	class C(D, F): pass                     /  |  \
	class B(D, E): pass                    D   E   F
	class A(B, C): pass                    \  /    /
                                                B     C(also inheriting from D)
                                                 \    /
                                                  \  /
                                                   A

	L[o] = O
	L[D] = D O
	L[e] = E O
	L[f] = F O
	L[B] = B + merge(L(D), L(E), DE)
	replace the leniarization of D, E, from above
	
	L[B] = B + merge(DO, EO, DE)

	D which is the starting head does not exist in tail of any other terms so we
	can take it out and set in the linerialization it modifies to

	L[B] = B + D merge(O, EO, E)
	
	since O exists in the tail of other so we cannot remove it from the list and we
	will have to look for other terms in list that is E, E does not exist in tail of 
	any other so we can move it to the linerialization list. 

	L[B] = B+D+E+merge(O,O) 

	Now O is not there is tail of any other terms so we will add this to the 		lineralization function.

	L[B] = B+D+E+O and that's complete


## The CYK Algorithm

	formal language

	A formal language over an alphabet Σ is a subset of Σ, that is a set words over that
	alphabet. The sets of words maybe grouped into expressions, and further rules and 
	constraints may be formulated for creation of "well-formed expressions."

	Take this example
	
	The following rules describe a formal language L over the alphabet Σ = {0, 1, 2, 3, 4
	5, 6, 7, 8, 9, +, =}

		> every nonempty string that does not contain "+" or "=" and does not start
		  with "0" in L.
		> The string "0" is in L
		> A string containing "=" is in L if and only if there is exactly one "=",
		  and it seprates two valid strings of L.
		> A string containing "+" but not "=" is in L if and only if every "+" in the
		  string seprates two valid string of l
		> No string in L other than those implied by previous rules

	Context Free Grammar
			
	In formal language theory, a context free grammar is a certain type of formal
	grammar: set of production rules that describes all possible strings in a given
	language.
	
	context free grammar are used to allow the construction of efficient parsing
	algorithms that. That for a given string determine weather and how it can 
	be generated from grammar.

	terminal symbol 
		symbols which cannot be further replaced by something
	nonterminal symbol
		symbols which can be further replaced by somthing
	
	eg  
		S-> a
		S-> Sb
		S can be replaced by a or Sb, that is S is non terminal
		while a is terminal

	Context-Free grammar are those grammars in which the left-hand side of each
	production rule consists of only single nonterminal symbol..

	

	The CYK algorithm is used to verify weather a certain word/string belong to a
	context free grammar. Or in other words if the string belong to a ceratin language
	or not. This finds its application in parsers. One condition for its implementaion 
	is the grammar should be in chomsy normal form. The worst case running time of 
	CYK is O(n^3) where n is length of parssed string.
	Which makes it one of the most efficient parsing algo in terms of worst case
	complexity. It can be implemented using dynamic programming.

	The implementaion invloves constructing a tringular strcture of length n and height
	n where the each cells are filled from by replacing the different combination of 	 terminal character with non terminal character and if final cell contains the starting
	character of grammar. The word is part of language or can be obtained from context
	free grammar. 

	The detailed step by step explation is below
	


	









