package game_engine2D;
import processing.core.PVector;
public class BoundingBox {
	public BoundingBox() {

	}

	public BoundingBox(int _l, int _r, int _t, int _b) {
		left = _l;
		right = _r;
		top = _t;
		bottom = _b;
	}
	public void fromSize(PVector size) {
		this.left = -size.x/2f;
		this.right = size.x/2f;
		this.top = -size.y/2f;
		this.bottom = size.y/2f;
	}
	
	public float left;
	public float right;
	public float top;
	public float bottom;
}
