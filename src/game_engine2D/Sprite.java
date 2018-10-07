package game_engine2D;

import processing.core.PApplet;

public abstract class Sprite extends GameObject {
	public Sprite(PApplet p) {
		super(p);
	}
	public Sprite(PApplet p, int x, int y) {
		super(p);
		this.transform.position.x = x;
		this.transform.position.y = y;
		
	}
	public abstract void update();

	@Override
	public void render() {
		//render components
	}

	@Override
	public void start() {
		//start all components
		
	}
}
