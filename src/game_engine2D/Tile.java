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

	public int strokeColour;
	public int fillColour;
	
	public Tile(PApplet p, float x, float y, float w, float h) {
		super(p, x, y);
		this.size.x = w;
		this.size.y = h;
		this.strokeColour = parent.color(255, 255, 255);
		this.fillColour = parent.color(33,10,155);
	}

	@Override
	public void start() {
		super.start();	
		this.transform.localBoundingBox.fromSize(size);
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void render() {
		
		parent.pushMatrix(); // reset the translation and rotation
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rectMode(PApplet.CENTER);
		parent.rect(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
	}
}
