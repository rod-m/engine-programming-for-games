package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import game_engine2D.data_management.*;

public class Launcher extends BaseLauncher {
	public boolean started = false;
	int waiting = 0;
	DataManager dataManager;
	GameScreen activeScreen;
	//ArrayList<GameScreen> screens = new ArrayList<GameScreen>();
	/*
	 * Game screens delegate game object management by screen
	 * This makes adding new levels or level editor easy
	 * Create a new GameScreen extended object for each screen
	 * StartScreen is the initial screen
	 * GameLevel has the original test game level
	 * To link GameLevel to StartScreen you send the GameScreen instance to exitScreensAdd
	 * */
	public Launcher(PApplet p) {
		super(p);
		StartGame();
	}

	public void keyPressed(char key, int keyCode) {
		super.keyPressed(key, keyCode);
		activeScreen.keyPressed(key, keyCode);
		
	}

	public void keyReleased(char key, int keyCode) {
		super.keyReleased(key, keyCode);
		activeScreen.keyReleased(key, keyCode);

	}

	public void StartGame() {
		StartScreen startScreen = new StartScreen(parent, this.gameManager);
		
		GameLevel gameLevel = new GameLevel(parent, this.gameManager);

		activeScreen = startScreen;
		started = true;
		
		startScreen.exitScreensAdd(gameLevel);
		LevelEditor levelEditor = new LevelEditor(parent, this.gameManager);
		startScreen.exitScreensAdd(levelEditor);
		levelEditor.exitScreensAdd(startScreen);
		this.gameManager.StartAll();
	
	}



	
	public void UpdateAll() {
		super.UpdateAll();
		
		if(activeScreen.swap_screen != null) {
			activeScreen = activeScreen.swap_screen;
			activeScreen.activated = false;
			activeScreen.swap_screen = null;
		}
		if(!activeScreen.activated) {
			activeScreen.start();
		}

	}

}
