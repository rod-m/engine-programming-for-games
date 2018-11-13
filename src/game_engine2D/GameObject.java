package game_engine2D;
import java.util.ArrayList;

import game_engine2D.game_components.GameComponent;
import processing.core.*;

public abstract class GameObject extends ProcessingEntity {
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}


	public String tag;
	
	public ArrayList<GameComponent> components;
	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public void keyPressed(char key, int keyCode) {}
	public void keyReleased(char key, int keyCode) {}
	public void mousePressed() {}
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {}

	public String ToString() {
		return this.name;
	}
}
