package game_engine2D;

import java.util.ArrayList;

import game_engine2D.data_management.DataManager;
import game_engine2D.game_components.BoundingBox;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/*
 * Use this class for new game scenes
 * Link exit screen to exitScreens
 * use swapTo to load next screen
 * */
public abstract class GameScreen extends ProcessingEntity {
	protected int exitScreen = -1;
	protected ArrayList<GameObject> gameObjects; // scene static elements like platforms
	protected ArrayList<GameObject> playerGameObjects; // player list for attaching interactions like key press
	protected ArrayList<GameObject> menuGameObjects; // player list for attaching interactions like key press

	protected ArrayList<GameScreen> exitScreens;
	public GameScreen swap_screen = null;
	protected ArrayList<BoundingBox> gameBoundingBoxes;
	protected GameManager gameManager;
	protected boolean ready = false; // data loaded
	public boolean activated = false; // synced with gameManager
	public GameScreen(PApplet p) {
		super(p);
		this.name = "Game Screen";
		
	}
	public GameScreen(PApplet p, GameManager _gameManager) {
		super(p);
		this.name = "Game Screen";
		this.gameManager = _gameManager;
		this.exitScreens = new ArrayList<GameScreen>();
		this.playerGameObjects = new ArrayList<GameObject>();
		this.menuGameObjects = new ArrayList<GameObject>();
		this.gameObjects = new ArrayList<GameObject>();
		this.gameBoundingBoxes = new ArrayList<BoundingBox>();
	}
	public void start(){
		if(!this.ready) {
		
			this.ready = true;
		}	
		this.activate();
	}
	public abstract void keyPressed(char key, int keyCode);
	public abstract void keyReleased(char key, int keyCode);
	public abstract void mousePressed();
	public abstract void mouseClicked(int mouseX, int mouseY, int mouseButton);

	public void exitScreensAdd(GameScreen _screen) {
		this.exitScreens.add(_screen);
	}
	public void swapTo(int i) {
		parent.println("From " + this.name + " swapTo " + i + " => ");
		if(this.exitScreen < this.exitScreens.size()) {
			this.exitScreen = i;
			this.swap_screen = this.exitScreens.get(this.exitScreen);

		}else {
			parent.println("Error: exitScreen out of range");

		}
	}
	
	public void activate() {
		GameManager.offset.x = 0f;
		GameManager.offset.y = 0f;
		// copy local gameobjects to gamemanager
		this.gameManager.replaceObjects(this.gameObjects);
		this.gameManager.replaceGUIObjects(this.menuGameObjects);
		this.gameManager.replacePlayerObjects(this.playerGameObjects);
		this.gameManager.replaceBoundingBoxes(this.gameBoundingBoxes);
		this.activated = true;
		this.gameManager.StartAll();
		parent.println("activated " + this.name);
	}
	protected boolean load_tile_json() {
		try {
			this.gameManager.dataManager = new DataManager(parent);
			this.gameManager.dataManager.load_data();
		} catch (Exception E) {
			return false;
		}
		JSONArray tiles;
		try {
			// simply load a list called "level1"
			// todo - make a list of levels and provide a menu to select
			tiles = this.gameManager.dataManager.game_data.getJSONArray("level1");
		} catch (Exception E) {
			// Oh, it doesn't exist, in this case revert to test level data
			
			return false;
		}

		for (int i = 0; i < tiles.size(); i++) {
			JSONObject tile;
			try {
				//get data - skip if null
				// the null one is probably the player sprite which will be handled separately
				tile = tiles.getJSONObject(i);
			} catch (Exception E) {
				continue;
			}
			int x = tile.getInt("x");
			int y = tile.getInt("y");
			int tw = tile.getInt("w");
			int th = tile.getInt("h");
			Tile platform = new Tile(parent, x, y, tw, th);
			platform.start();
			this.gameObjects.add(platform);
			this.gameBoundingBoxes.add(platform.transform.NewWorldBoundingBox());
		}
		return true;
	}

}
