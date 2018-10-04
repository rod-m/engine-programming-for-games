package game_engine2D;
import processing.core.*;
import processing.data.JSONObject;

public abstract class GameObject{
	  public String name;
	    public PApplet parent; // The parent PApplet that we will render ourselves onto
	    
	   
	    public GameObject(){}
	    public GameObject(PApplet p){
	        parent = p;
	    }
	 
	    public abstract void update();
	    public abstract void render();
}
