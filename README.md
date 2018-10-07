# Games Engine programming tutorial
Java based with processing 3 as the core library.

# Installation
Setup a java IDE like Eclipse to extend the processing.org papplet.
see tutorial here https://processing.org/tutorials/eclipse/

Each branch forms a new sprint checkpoint.
# Master branch
Skeleton GameObject setup.

# Sprint 1
Very basic Game manager which can handle a list of GameObjects, update and render them.
A Sprite class which extends the GameObjects class.
BaseLauncher is an abstract class for making and launching new games.


Created a new package simple_platformer for a demo game which uses the game_engine2D package.
Launcher class extends BaseLauncher. A good starting point for a generic Sprite management system.

# Sprint 2
New GameComponent class for adding things like physics, collisions etc. 
Physics2D component starts by adding gravity to the player. 

# Sprint 3
Box collider for collisions. 
Configured the game manager to track player object collisions with platforms. 
Added some functionality to the Transform class to return a bounding box of current object world coordinates.
Passing key press events to player object. Using key 'w' as a jump action.

