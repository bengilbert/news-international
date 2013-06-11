# News International Programming Challenge

This is a solution for a News International programming challenge.  It has been developed in a reasonable quick fashion.  
The solution is slightly more verbose than what it really needs to be (chosing Java probably wasn't the best idea due to
its heavy weight approach).  The verbosity came out of my desire to make the application more testable and to provide 
question points for OO design.  Object calisthenics provided some inspiration for the solution and I would like to further
the implementation in the future using more of these ideas as there are way to many uses of the switch statement for my liking!
Good OO design has arguably this has been achieved however the the implementation is stuck in the awkward stage of being
to simple to justify its size and to brittle to claim completeness.

The challenge was very interesting and I will certainly use a similar programming challenge when interviewing candidates
myself as the problem touches on so many facets of software development - if anything to many!

The class Main can be used to run the application.  Pass in as a paramter the name of the command file you wish to process.

e.g.

<pre><code>mvn clean install
java -jar target/robot-0.0.1-SNAPSHOT.jar src/main/java/sample-commands.txt</code></pre>

The original requirements are shown below.



## Problem Statement

A squad of robots will be landed on a plateau. This plateau, which is curiously rectangular, must be navigated by the robots so that their on-board cameras can get a complete view of the surrounding terrain to send back to controller.
A robot's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the robots is in the bottom left corner and facing North.
In order to control a robot, Controller sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintains the same heading.
Assume that the square directly North from (x, y) is (x, y+1).

### INPUT

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the robots that have been deployed. Each robot has two lines of input. The first line gives the robot's position, and the second line is a series of instructions telling the robot how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the robot's orientation.

### OUTPUT

The output for each rover should be its final co-ordinates and heading.

### INPUT AND OUTPUT


#### Test Input

<pre><code>5 5
1 2 N
LMLMLMLMM</code></pre>

#### Expected Output

<pre><code>1 3 N</code></pre>


