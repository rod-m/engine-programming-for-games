package game_engine2D;
import processing.core.*;
import java.util.ArrayList;
/* Example of basic Launch processing applet*/
public class GameManager {
    public PApplet parent; // The parent PApplet that we will render ourselves onto
    public int background = 0;
    private ArrayList<GameObject> gameObjects;
    private ArrayList<GameObject> playerGameObjects;
    private ArrayList<BoundingBox> gameBoundingBoxes;

    public GameManager(PApplet p){
        parent = p;
        gameObjects = new ArrayList<GameObject>();
        playerGameObjects = new ArrayList<GameObject>();
        gameBoundingBoxes = new ArrayList<BoundingBox>();
    }
    public void addGameBoundingBoxes(GameObject b){
    	gameBoundingBoxes.add(b.transform.WorldBoundingBox());
    }
    public void addPlayerGameObjects(GameObject b){
    	playerGameObjects.add(b);
    }
  
    public void addObject(GameObject g){
        gameObjects.add(g);
    }
    public void removeObject(GameObject g){
        gameObjects.remove(gameObjects.lastIndexOf(g));
    }
    public void StartAll() {
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
           
        }
    }
    public void checkCollisions() {
    	 for(int i = 0; i < gameBoundingBoxes.size(); i++){
    		 BoundingBox bb = gameBoundingBoxes.get(i);
    		 for(int j = 0; j < playerGameObjects.size(); j++){
    	            GameObject p = playerGameObjects.get(j);
    	            p.checkCollisions(bb);
    	           
    	        }
            
         }
    }
    
    public void UpdateAll() {
    	checkCollisions();
    	parent.background(background);
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
    }
    public void keyPressed(char key, int keyCode) {
for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.keyPressed(key, keyCode);
        }
    	
    }


}
