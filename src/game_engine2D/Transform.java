/**
 * 
 */
package game_engine2D;

import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Transform {

	public Transform() {
		
	}
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);
	public BoundingBox boundingBox = new BoundingBox(-1,1,-1,1);
	public BoundingBox WorldBoundingBox() {
		BoundingBox bb = new BoundingBox();
		bb.left = position.x + boundingBox.left;
		bb.right = position.x + boundingBox.right;
		bb.top = position.y + boundingBox.top;
		bb.bottom = position.y + boundingBox.bottom;
		return bb;
	}
}
