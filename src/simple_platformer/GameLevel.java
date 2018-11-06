package simple_platformer;

import game_engine2D.Camera2D;
import game_engine2D.GameManager;
import game_engine2D.GameScreen;
import game_engine2D.Tile;
import game_engine2D.data_management.DataManager;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class GameLevel extends GameScreen {
	public GameLevel(PApplet p, GameManager _gameManager) {
		super(p, _gameManager);
		this.name = "Game Level 1";
	}

	private DataManager dataManager; // todo - load external level data
	

	@Override
	public void start() {
		super.start();		
		Player player = new Player(parent, parent.width / 2, parent.height / 2, 60, 60);
		player.start();
		this.playerGameObjects.add(player);
		this.gameObjects.add(player);
		Camera2D camera = new Camera2D(parent, player, 99);
		camera.cameraOffset.y = 90;
		this.gameObjects.add(camera);
		//tile_json();
		random_tiles();
		this.ready = true;
		this.activate();
		
	}
	
	private void tile_json() {
		dataManager = new DataManager(parent);
		dataManager.load_data();
		JSONArray tiles = dataManager.game_data.getJSONArray("tiles");
		for (int i = 0; i < tiles.size(); i++) {
			JSONObject tile = tiles.getJSONObject(i);
			int x = tile.getInt("x");
			int y = tile.getInt("y");
			int tw = tile.getInt("w");
			int th = tile.getInt("h");
			Tile platform = new Tile(parent, x, y, tw, th);
			platform.start();
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		}
	}
	
	@Override
	public void keyPressed(char key, int keyCode) {
		// TODO Auto-generated method stub

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

	public void random_tiles() {
		int platforms = 500;
		Tile platform;
		int tw = 50;
		int th = 20;
		int numPlatformsX = 2 * parent.width / tw;
		int numPlatformsY = 2 * parent.height / th;
		for (int i = 0; i < platforms; i++) {
			int x = (int) parent.random(0, numPlatformsX) * tw;
			int y = (int) parent.random(-numPlatformsY, numPlatformsY) * th;
			platform = new Tile(parent, x, y, tw, th);
			platform.start();
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		}

		// GROUND

		for (int i = 0; i < 40; i++) {
			platform = new Tile(parent, i * tw, parent.height * 2, tw, th);
			platform.start();
			platform.strokeColour = parent.color(0, 200, 200);
			platform.fillColour = parent.color(0, 200, 200);
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		
		}

		// left
		for (int i = 0; i < 200; i++) {
			platform = new Tile(parent, 0, (-parent.height * 3) + (th + 2) * i, tw, th);
			platform.start();
			platform.strokeColour = parent.color(0, 200, 200);
			platform.fillColour = parent.color(0, 200, 200);
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		
		}
		// right
		for (int i = 0; i < 200; i++) {
			platform = new Tile(parent, parent.width * 2, (-parent.height * 3) + th * i, tw, th);
			platform.start();
			platform.strokeColour = parent.color(0, 200, 200);
			platform.fillColour = parent.color(0, 200, 200);
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		
		}


	
	}

}
