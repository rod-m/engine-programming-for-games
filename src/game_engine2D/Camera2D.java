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
public class Camera2D extends GameObject {
	public GameObject followMe;
	public float offsetLimit = 100;
	public PVector cameraOffset = new PVector(0,0);
	public Camera2D(PApplet p, GameObject f) {
		super(p);
		this.followMe = f;
	}
	public Camera2D(PApplet p, GameObject f, float limit) {
		super(p);
		this.followMe = f;
		offsetLimit = limit;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}


	@Override
	public void update() {
	
	}

	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		late_update_xy();
	}
	
	
	private void late_update_xy() {
		// copy screen offset centre
		PVector virtualScreenCentre = GameManager.screenOffset.copy();
		// add current global offset
		virtualScreenCentre.add(GameManager.offset);
		// setup player virtual global position
		PVector virtualPlayer = GameManager.offset.copy();
		virtualPlayer.add(this.followMe.transform.position);
		// check distance between player and virtual centre
		float d = virtualScreenCentre.dist(virtualPlayer);
		
		if (d > offsetLimit) {
			// get difference between virtual centre and player
			virtualScreenCentre.sub(virtualPlayer);
			// add custom camera offset
			virtualScreenCentre.add(this.cameraOffset);
			// transform toward to new offset
			GameManager.offset.lerp(virtualScreenCentre, 0.02f);
		}
	}

}
