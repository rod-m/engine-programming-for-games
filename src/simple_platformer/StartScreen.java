package simple_platformer;

import java.util.ArrayList;

import game_engine2D.GameManager;
import game_engine2D.GameObject;
import game_engine2D.GameScreen;
import game_engine2D.GUI.MenuMaker;
import game_engine2D.game_components.BoundingBox;
import processing.core.PApplet;

public class StartScreen extends GameScreen {

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
	public void mouseClicked() {
		// TODO Auto-generated method stub

	}

	

}
