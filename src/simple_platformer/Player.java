/**
 * 
 */
package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Player extends Sprite {
	float speed = 3f;
	float gravity = 0.1f;
	public PVector size = new PVector(12,12);
	private Physics2D physics;
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);
	/**
	 * @param p
	 */
	public Player(PApplet p) {
		super(p);
	}
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	        speed = 3.0f;
	    }
	 public void start() {
		 this.transform.position.x = parent.width / 2;
		 this.transform.position.y = parent.height / 2;
		 this.physics = new Physics2D(this);
		 this.physics.start();
	 }


	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	@Override
	public void render(){
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);

	}
}
