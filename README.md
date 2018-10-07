# engine-programming-for-games
Work in progress on a 2D Game Engine using Eclipse java and the processing applet library.

Each branch forms a new sprint checkpoint.
# Sprint 1
Very basic Game manager which can handle a list of GameObjects, update and render them.
A Sprite class which extends the GameObjects class.
BaseLauncher is an abstract class for making and launching new games.

simple_platformer
Created a new package for a demo game which uses the game_engine2D package.
Launcher class extends BaseLauncher. A good starting point for a generic Sprite management system.

# sprint 2
New GameComponent class for adding things like physics, collisions etc
Physics2D component starts by adding gravity to the player.

