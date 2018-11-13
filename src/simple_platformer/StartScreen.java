package simple_platformer;

import game_engine2D.GameManager;
import game_engine2D.GameScreen;
import game_engine2D.GUI.MenuMaker;
import processing.core.PApplet;

public class StartScreen extends GameScreen {
	/* New start screen
	 * displays a basic list of scenes to load
	 * menu maker is a very basic list of menu options
	 * */
	MenuMaker menuMaker;

	public StartScreen(PApplet p, GameManager _gameManager) {
		super(p, _gameManager);
		this.name = "Start screen";
	}

	@Override
	public void start() {
		super.start();
	
		menuMaker = new MenuMaker(parent, this.exitScreens);
		menuMaker.start();
		this.gameObjects.add(menuMaker);
		this.ready = true;
		this.activate();
	}

	@Override
	public void keyPressed(char key, int keyCode) {
		if(key == '1') {
		
			this.swapTo(0);
		}
		// add any new key presses to load extra screens here
		// we will add a level editor next!
		
		if(key == '2') {
			// level editor coming next...
			this.swapTo(1);
		}
		

	}

	@Override
	public void keyReleased(char key, int keyCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		// TODO Auto-generated method stub

	}

	

}
