package simple_platformer;

import game_engine2D.Camera2D;
import game_engine2D.GameManager;
import game_engine2D.GameScreen;
import game_engine2D.GUI.MenuMaker;
import processing.core.PApplet;

public class LevelEditor extends GameScreen {
	MenuMaker menuMaker;
	public LevelEditor(PApplet p, GameManager _gameManager) {
		super(p, _gameManager);
		this.name = "Level Editor";
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
			//load start screen
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
