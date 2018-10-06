package game_engine2D;

import processing.core.*;

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
		for (int i = this.components.size() - 1; i >= 0; i--) {
			GameComponent comp = this.components.get(i);
			comp.update();
			comp.render();
		}
	}

	@Override
	public void start() {
		//start all components
		for (int i = this.components.size() - 1; i >= 0; i--) {
			GameComponent comp = this.components.get(i);
			comp.start();
		}
	}
}
