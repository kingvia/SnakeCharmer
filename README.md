# SnakeCharmer
* Input File: snakein.txt
* Output File: snakeout.txt
* Time Limit: 1 second
* Memory Limit: 1 GB

You are a snake charmer performing for a travelling circus troupe. For your next act, you will show off your skills by charming your snake to move to a place selected by an audience member. To perform this act, you have created a grid for your snake to move around in. Initially your snake starts off in a square in the middle of this grid facing north, and you will ask the audience for a goal square for your snake to reach. However, your snake is very peculiar: it only likes to move by zigzagging around. More specifically you can only make your snake move in two ways:
* An L move: make it turn left and then move forward by one square.
* An R move: make it turn right and then move forward by one square.
For instance, consider the following grid in a coordinate system.
 
Your snake will always start off at the square (0,0). In the above grid, the flag square at (-1,2) represents the goal square selected by the audience, and the dots show the path taken. The snake is initially facing north, so the sequence of moves taken by it are:
1. An R move: it turns right to face east and moves forward one square to the square (1,0).
2. An L move: it turns left to face north and moves forward one square to the square (1,1).
3. An L move: it turns left to face west and moves forward one square to the square (0,1).
4. An R move: it turns right to face north and moves forward one square to the square (0,2).
5. An L move: it turns left to face west and moves forward one square to square (-1,2), which is the goal square where it stops.
Now, you realise that the longer it takes for your snake to get to the goal square, the less interested your audience will become. Can you find the shortest path for you to charm your snake to the goal square? If there are multiple shortest paths, you only need to find one of them.

# Input
The input file consists of one line with two integers x and y representing the (x,y) coordinates of the goal square.

#Output
Your output file should consist of a single line of Ls and Rs, representing a sequence of moves that will charm your snake from the starting point to the goal square.

# Sample Input
-1 2
# Sample Output
RLLRL
