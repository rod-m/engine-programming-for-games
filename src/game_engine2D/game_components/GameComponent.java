package game_engine2D.game_components;

import game_engine2D.GameObject;
import game_engine2D.ProcessingEntity;
import game_engine2D.Transform;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public abstract class GameComponent extends ProcessingEntity{
    public GameComponent(GameObject g) {
		super(g.parent);
		/* Generic Component */
		this.gameObject = g; //components are linked to a gameObject
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}
	public GameObject gameObject;
	public Transform transform;
	public abstract void start();
	public abstract void update();
	public abstract void render();
}
