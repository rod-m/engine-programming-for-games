package game_engine2D.level_editor;

import java.util.ArrayList;

import game_engine2D.GameObject;
import game_engine2D.Tile;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import game_engine2D.data_management.*;

public abstract class MainMenu extends GameObject {
	private JSONArray menuItems; // player list for attaching interactions like key press
	private DataManager dataManager;
	private String menu_file = "level_edit_menu.json";
	public MainMenu(PApplet p) {
		super(p);
	}
	@Override
	public void start() {
		dataManager = new DataManager(parent, menu_file);
		dataManager.load_data();
		this.menuItems = dataManager.game_data.getJSONArray("menuItems");
	
	}
	public void start(String _filename) {
		menu_file = _filename;
		this.start();
		
	}
	@Override
	public void render() {
	
		for (int i = 0; i < this.menuItems.size(); i++) {
			JSONObject menu = this.menuItems.getJSONObject(i);
			String name = menu.getString("name");
			parent.text(i +": " + name, parent.width/2 - 40, 120 + i * 30);
	
		
		}
		
	}
	
}
