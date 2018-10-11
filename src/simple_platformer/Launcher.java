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
        this.gameManager.addPlayerGameObjects(player);
        Camera2D camera = new Camera2D(parent,player, 99);
        camera.cameraOffset.y = 90;
        this.gameManager.addObject(camera);
        int platforms = 8;
        Tile platform;
     
        for(int i = 0; i < platforms; i++){
            platform = new Tile(parent, parent.random(parent.width),parent.random(parent.height),50, 20);
            platform.start();
            this.gameManager.addObject(platform);
            this.gameManager.addGameBoundingBoxes(platform);
        }
        
        
        for(int i = 0; i < platforms; i++){
            platform = new Tile(parent, 26+ i * 50,40 + 15 * i,50, 20);
            platform.start();
            this.gameManager.addObject(platform);
            this.gameManager.addGameBoundingBoxes(platform);
        }
        
        platform = new Tile(parent, parent.width/2, parent.height-100,50, 50);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        platform = new Tile(parent, (parent.width*0.75f),(parent.height*0.65f),60, 20);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        platform = new Tile(parent, (parent.width*0.65f),(parent.height*0.45f),60, 20);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        //GROUND
        platform = new Tile(parent, parent.width/2, parent.height-10,parent.width, 20);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        //left
        platform = new Tile(parent, 0, parent.height/2, 20, parent.height * 10);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        //right
        platform = new Tile(parent, parent.width, parent.height/2, 20, parent.height*10);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
    }
	  public void UpdateAll(){
	        super.UpdateAll();
	    }

}
