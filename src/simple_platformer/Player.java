/**
 * 
 */
package simple_platformer;

import game_engine2D.*;
import game_engine2D.game_components.Physics2D;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Player extends Sprite {
	float speedForce = 3f;
	float jumpForce = 10f;
	public PVector size = new PVector(12, 12);
	private Physics2D physics;
	public int stroke = parent.color(120, 120, 255);
	public int fill = parent.color(255);
	private char keyDownLeft = '-';
	private char keyDownRight = '-';
	private char keyDownUp = '-';

	/**
	 * @param p
	 */
	public Player(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Player(PApplet p, float x, float y, float w, float h) {
		super(p);

	}

	public void start() {
		this.transform.position.x = parent.width / 2;
		this.transform.position.y = parent.height / 2;
		this.transform.localBoundingBox.fromSize(size);
		this.physics = new Physics2D(this);
		this.physics.start();
		this.physics.speed = speedForce;
	
	}

//	public void checkCollisions(BoundingBox bb) {
//		this.physics.checkCollisions(bb);
//	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void render() {
		parent.rectMode(PApplet.CENTER);
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
		parent.textSize(12);
		parent.text("#" + this.physics.collisionCount, this.transform.position.x - 4, this.transform.position.y - 15);

	}

	public void keyPressed(char key, int keyCode) {
		super.keyPressed(key, keyCode);
		// mapped key pressed
		if (keyDownLeft == '+' && keyCode == PApplet.UP) {
			this.physics.jump(jumpForce);
			this.physics.move(-speedForce);
		} else if (keyDownRight == '+' && keyCode == PApplet.UP) {
			this.physics.jump(jumpForce);
			this.physics.move(speedForce);
		} else if (keyCode == PApplet.UP) {
			keyDownUp = '+';
			this.physics.jump(jumpForce);
		} else if (keyCode == PApplet.LEFT) {
			keyDownLeft = '+';
			this.physics.move(-speedForce);
		} else if (keyCode == PApplet.RIGHT) {
			keyDownRight = '+';
			this.physics.move(speedForce);
		}
		
	}

	public void keyReleased(char key, int keyCode) {
		super.keyReleased(key, keyCode);
		
		if(keyCode == PApplet.UP) {
			keyDownUp = '-';
		}else if(keyCode == PApplet.LEFT) {
			keyDownLeft = '-';
		}else if(keyCode == PApplet.RIGHT) {
			keyDownRight = '-';
		}
		this.physics.keyUp();
	}

}
