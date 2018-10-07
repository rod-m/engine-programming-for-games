package game_engine2D;
import java.util.ArrayList;

import processing.core.*;

public abstract class GameObject extends ProcessingEntity {
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}

	public String name;
	public String tag;
	
	public ArrayList<GameComponent> components;
	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	//public void checkCollisions( BoundingBox bb) {}
	public void keyPressed(char key, int keyCode) {}
	public void keyReleased(char key, int keyCode) {}
	
	public String ToString() {
		return this.name;
	}
}
