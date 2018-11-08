package game_engine2D.GUI;

import java.util.ArrayList;

import game_engine2D.ALIGNMENT;
import game_engine2D.DIRECTION;
import game_engine2D.GameObject;
import game_engine2D.GameScreen;
import processing.core.PApplet;
import processing.core.PVector;

public class MenuMaker extends GameObject {
	/* Display a list of menu options
	 * */
	private ArrayList<String> menu_options = new ArrayList<String>();
	// private int selected = 0;
	private int w = 160,h = 30, padding = 15;

	public DIRECTION direction = DIRECTION.HORIZONTAL;
	public ALIGNMENT alignment = ALIGNMENT.BOTTOM_LEFT;
	public MenuMaker(PApplet p) {
		super(p);
		
	}

	
	public MenuMaker(PApplet p, ArrayList<GameScreen> _screens) {
		super(p);
		for(int i=0; i < _screens.size(); i++) {
			this.menu_options.add(_screens.get(i).name);
		}
		
	}
	
	@Override
	public void start() {
		if(this.alignment == ALIGNMENT.CENTRED) {
			this.transform.position.x = parent.width /2 - w/2;
			this.transform.position.y = parent.height /2 - h * this.menu_options.size();
		}else {
			this.transform.position.x = this.padding;
			this.transform.position.y = this.padding;
		}
		
	}
	

	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.transform.position.x, this.transform.position.y);
		for(int i=0; i < this.menu_options.size(); i++) {
			//parent.rectMode(PApplet.CENTER);
			parent.fill(0);
			parent.stroke(255);
			if(this.direction == DIRECTION.VERTICAL) {
				parent.rect(0, i * h, w, h);
			}else {
				parent.rect(i*w, 0, w, h);
			}
			
			parent.fill(255);
			parent.noStroke();
			PVector textPos;
			if(this.direction == DIRECTION.VERTICAL) {
				textPos = new PVector(this.padding,h/2 + 5+ i * h);
			}else {
				textPos = new PVector(i * w +this.padding,h*0.7f);
			}
			parent.text((i+1) + ": "+this.menu_options.get(i), textPos.x,textPos.y);

		}
		parent.popMatrix();
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
