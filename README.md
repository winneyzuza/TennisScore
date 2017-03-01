Tennis                         	
 
•    Problem description
Serena Williams would like you to create a Tennis mobile game for her own. The rule is the same as the general tennis, but we play just one game.
 
1.     Player can have these point in game 0 15 30 40
2.     Player who have 40 and win the ball will win the game
3.     If both players have 40, it will be deuce and player who has the advantage and win the ball will win the game
 
Additional rule is here: http://en.wikipedia.org/wiki/Tennis#Scoring
 
 
•    Input file format
 
GAME1: A A A A
GAME2: A B A B A A
 	GAME3: B B A A A B A B B B
 
•    Output format
 
GAME1
A: 15
A: 30
A: 40
A: WIN
 
GAME2
A­­: 15
B: 15
A: 30
B: 30
A: 40
A: WIN
 

GAME3
B: 15
B: 30
A: 15
A: 30
A: 40
B: 40
DUCE
A: ADV
B: ADV
DUCE
B: ADV
B: WIN
