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
	public BoxCollider2D boxCollider2D;
	float gravity = 0.1f;
	boolean canJump = true;
	boolean hasHitSomething = false;
	/**
	 * @param g
	 */
	public Physics2D(GameObject g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see game_engine2D.GameComponent#start()
	 */
	@Override
	public void start() {
		this.boxCollider2D = new BoxCollider2D(this.gameObject);

	}

	/* (non-Javadoc)
	 * @see game_engine2D.GameComponent#update()
	 */
	@Override
	public void update() {
		gravityEffect();
		this.transform.position.y += velocity.y;
		//if(this.boxCollider2D.checkCollision(_boundingBox))
	}
	public void checkCollisions(BoundingBox _boundingBox) {
		if( this.boxCollider2D.checkCollision(_boundingBox)) {
			velocity = new PVector(0,0);
			isGrounded();
			hasHitSomething = true;
		}
		
	}
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	public void jump(int force) {
		if(canJump) {
			velocity.y = -force;
			canJump = false;
			hasHitSomething = false;
		}
		
	}
	public void isGrounded() {
		canJump = true;
	}
	private void gravityEffect() {
		if(hasHitSomething) return;
		velocity.y += gravity;
		if (velocity.y >= 4f) {
			velocity.y = 4f;
		}
	}


}
