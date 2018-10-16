# Games Engine programming tutorial
Java based with processing 3 as the core library.

# Installation
Setup a java IDE like Eclipse to extend the processing.org papplet.
see tutorial here https://processing.org/tutorials/eclipse/

# Eclipse and GIT
Due to a bug with importing a git repo as a Java Project, you should first import from git and create an new general project. If the project was added to your work directory you can remove the project without deleting the files. Then you can use the option in Eclipse - 'Open Projects from file system', select the git repo content folder. This will force Eclipse to recognise the project as a java project. An odd workaround but will work. 

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

# Sprint 4
Added Arrow movements ~ there is an osx issue with keypress, the arrow keys are ok. The new osx will use unicode special characters after multiple key presses.
Made collision system, gravity, friction.

# Sprint 5
Added offset grid with a Camera2D

# Sprint 6
Spatial Grid collision system. Player has text displaying number of tiles tested.
Fixed sticking to walls - checked left/right bounding box before top/bottom. Added a 2 pixel bounce off sides.
Placed platforms on grid. Added reload option for test.

