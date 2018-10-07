/**
 * 
 */
package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Physics2D extends GameComponent {
	int frameWait = 0;
	int frameDelay = 2;
	private PVector velocity = new PVector(0, 0);
	public BoxCollider2D boxCollider2D;
	float gravity = 0.1f;
	float friction = 0.9f;
	float frictionOveride = 1.0f;
	float frictionNormal = 0.9f;
	boolean isGrounded = false;
	public float speed = 3f;
	public float maxSpeed = 5f;

	/**
	 * @param g
	 */
	public Physics2D(GameObject g) {
		super(g);
	}

	@Override
	public void start() {
		this.boxCollider2D = new BoxCollider2D(this.gameObject);

	}

	@Override
	public void update() {

		frameWait++;

		
		if (frameWait > frameDelay) {
			frameWait = 0;
			checkCollisions();
		}
		
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		gravityEffect();
		if (isGrounded ) {
			this.velocity.x *= friction;
		}
		if (PApplet.abs(velocity.x) >= maxSpeed) {
			if(velocity.x > 0)
				velocity.x = maxSpeed;
			else
				velocity.x = -maxSpeed;
		}
		if (isGrounded && PApplet.abs(velocity.x) <= 0.1f) {
			velocity.x = 0f;
		}
		this.transform.position.add(velocity);
	}

	private void checkCollisions() {
		if (PApplet.abs( this.transform.prev_position.x - this.transform.position.x) < 0.1f) {
			if (PApplet.abs( this.transform.prev_position.y - this.transform.position.y) < 0.1f) {
				return;
			}
		}
		for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++) {

			HitInfo hitInfo = new HitInfo();
			hitInfo.boundingBox = GameManager.gameBoundingBoxes.get(i);
			hitInfo = this.boxCollider2D.checkCollision(hitInfo);
			if (hitInfo.didHit) {
				// this.velocity = hitInfo.velocity;
				switch (hitInfo.hitSide) {
				case TOP:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.bottom + this.transform.boundingBox.bottom;

					break;
				case BOTTOM:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.top + this.transform.boundingBox.top;
					if(!isGrounded) {
						isGrounded = true;
						velocity.x = 0f;
					}
					
					break;
				case LEFT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.left + this.transform.boundingBox.left;

					break;
				case RIGHT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.right + this.transform.boundingBox.right;

					break;
				case NONE:
					isGrounded = false;
					break;
				}
			}

		}
	}

	@Override
	public void render() {

	}

	public void jump(int force) {
		if (isGrounded) {
			// impulse force UP
			velocity.y = -force;
			isGrounded = false;

		}

	}

	private void gravityEffect() {

		velocity.y += gravity;
		if (PApplet.abs(velocity.y) >= maxSpeed) {
			velocity.y = maxSpeed;
		}

	}

	public void move(float force) {
		if (isGrounded) {
			this.friction = this.frictionOveride;
			velocity.x += force;
		}

	}

	public void keyUp() {
		if (isGrounded) {
			this.friction = this.frictionNormal;
			
		}

	}

}
