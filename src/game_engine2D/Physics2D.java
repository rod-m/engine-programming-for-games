/**
 * 
 */
package game_engine2D;

import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Physics2D extends GameComponent {
	private PVector velocity = new PVector(0,0);
	
	float gravity = 0.1f;
	boolean canJump = true;
	/**
	 * @param g
	 */
	public Physics2D(GameObject g) {
		super(g);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void start() {

	}


	@Override
	public void update() {
		gravityEffect();
		this.transform.position.y += velocity.y;
		//if(this.boxCollider2D.checkCollision(_boundingBox))
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	public void jump(int force) {
		if(canJump) {
			velocity.y = -force;
			canJump = false;
			
		}
		
	}
	public void isGrounded() {
		canJump = true;
	}
	private void gravityEffect() {
		
		velocity.y += gravity;
		if (velocity.y >= 4f) {
			velocity.y = 4f;
		}
	}


}
