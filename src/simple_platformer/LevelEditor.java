package simple_platformer;

import game_engine2D.Camera2D;
import game_engine2D.GameManager;
import game_engine2D.GameScreen;
import game_engine2D.Tile;
import game_engine2D.GUI.MenuMaker;
import processing.core.PApplet;

public class LevelEditor extends GameScreen {
	MenuMaker menuMaker;
	int platform_width = 50;
	int platform_height = 20;
	int levelID = 1;
	public LevelEditor(PApplet p, GameManager _gameManager) {
		super(p, _gameManager);
		this.name = "Level Editor";
	}
	@Override
	public void start() {
		super.start();		
		menuMaker = new MenuMaker(parent, this.exitScreens);
		menuMaker.add_menu_item("A - add platform");
		menuMaker.add_menu_item("S - save level");
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
		}else if (Character.toUpperCase(key) == 'S') {
			//save tiles as json array
			// the levelID is 1, todo - make list of levels to save/load
			this.gameManager.dataManager.save_tiles_json(this.gameObjects, "level"+levelID);
			
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
		// add platform
		parent.println("level edit click");
		add_platform(mouseX, mouseY);
	}
	void add_platform(int x, int y) {
		// adds a platform where mouse clicked
		// todo - add navigation to move beyond visible screen
		// todo - arrange tiles in a grid
		// add a remove platform option - requires collision test
		Tile platform = new Tile(parent, x, y, platform_width, platform_height);
		platform.start();
		this.gameObjects.add(platform);
		this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
	}
}
