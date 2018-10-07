package simple_platformer;


import game_engine2D.*;
import processing.core.PApplet;


public class Launcher extends BaseLauncher{

	public Launcher(PApplet p) {
		super(p);
	}

	public void StartGame(){
		super.StartGame();
        Player player = new Player(parent, parent.width/2,parent.height/2,60, 60);
        player.start();
        this.gameManager.addObject(player);
     
        int platforms = 8;
        for(int i = 0; i < platforms; i++){
            Tile platform = new Tile(parent, 50 + i * 55, parent.height-50,50, 20);
            platform.start();
            this.gameManager.addObject(platform);
        }
    }
	  public void UpdateAll(){
	        super.UpdateAll();
	    }

}
