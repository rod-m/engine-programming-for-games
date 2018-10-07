package game_engine2D;

public class BoxCollider2D extends ProcessingEntity {
	public BoundingBox boundingBox;
	public Transform transform = new Transform();
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	
		
	}
	public boolean checkCollision(BoundingBox tile_bb) {
		//collision with static _boundingBox
		this.boundingBox = this.transform.WorldBoundingBox();
		if(tile_bb.left < this.boundingBox.right && tile_bb.right > this.boundingBox.left) {
			if(tile_bb.top < this.boundingBox.bottom ) {
				this.transform.position.y = tile_bb.top - this.transform.boundingBox.bottom;
				return true;
			}
			if( tile_bb.bottom < this.boundingBox.top) {
				//return true;
			}
		}
		return false;
	}

}
