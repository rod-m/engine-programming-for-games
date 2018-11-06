package game_engine2D;

import java.util.ArrayList;

import game_engine2D.game_components.BoundingBox;
import processing.core.PApplet;

/*
 * Use this class for new game scenes
 * Link exit screen to exitScreens
 * use swapTo to load next screen
 * */
public abstract class GameScreen extends ProcessingEntity {
	protected int exitScreen = -1;
	protected ArrayList<GameObject> gameObjects; // scene static elements like platforms
	protected ArrayList<GameObject> playerGameObjects; // player list for attaching interactions like key press
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
		this.gameObjects = new ArrayList<GameObject>();
		this.gameBoundingBoxes = new ArrayList<BoundingBox>();
	}
	public void start(){
		if(this.ready) {
			this.activate();
			return;
		}		
	}
	public abstract void keyPressed(char key, int keyCode);
	public abstract void keyReleased(char key, int keyCode);
	public abstract void mousePressed();
	public abstract void mouseClicked();

	public void exitScreensAdd(GameScreen _screen) {
		this.exitScreens.add(_screen);
	}
	public void swapTo(int i) {
		if(this.exitScreen != i && this.exitScreen < this.exitScreens.size()) {
			this.exitScreen = i;
			this.swap_screen = this.exitScreens.get(this.exitScreen);
			parent.println("swapTo " + i + " => " + this.name);
			
		}
		
		
	}
	public void activate() {
		// copy local gameobjects to gamemanager
	
		this.gameManager.replaceObjects(this.gameObjects);
		this.gameManager.replacePlayerObjects(this.playerGameObjects);
		this.gameManager.replaceBoundingBoxes(this.gameBoundingBoxes);
		this.activated = true;
		this.gameManager.StartAll();
		parent.println("activated " + this.name);
	}
}
