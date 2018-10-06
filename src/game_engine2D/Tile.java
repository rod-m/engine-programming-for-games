/**
 * 
 */
package game_engine2D;

import processing.core.PApplet;

/**
 * @author rod martin r.martin1@salford.ac.uk
 *
 */
public class Tile extends Sprite {
	public int width;
	public int height;
	int strokeColour;
	int fillColour;
	
	public Tile(PApplet p, int x, int y, int w, int h) {
		super(p, x, y);
		this.width = w;
		this.height = h;
		this.strokeColour = parent.color(255, 255, 255);
		this.fillColour = parent.color(0, 0, 0);
	}

	@Override
	public void start() {
		super.start();
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		super.render();
		parent.pushMatrix(); // reset the translation and rotation
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rect(0, 0, this.width, this.height);
		parent.popMatrix();
	}
}
