package game_engine2D.game_components;

import game_engine2D.SIDES;

public class HitInfo {
	/*
	 * Collision Helper
	 * */

	public SIDES hitSide = SIDES.NONE;
	public BoundingBox boundingBox;
	public boolean didHit = false;

}
