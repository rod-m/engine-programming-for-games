/**
 * 
 */
package game_engine2D;

import processing.core.PApplet;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public abstract class ProcessingEntity {
	public String name;
	public int ID;
    public PApplet parent; // The parent PApplet that we will render ourselves onto
    
    public ProcessingEntity(PApplet p){
        parent = p;
    }
}
