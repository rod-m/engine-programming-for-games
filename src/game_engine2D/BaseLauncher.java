package game_engine2D;
import processing.core.PApplet;
/* Example of basic Launching game manager
 * This will be used when making a new game package like asteroids
 *  */
public abstract class BaseLauncher {
    public PApplet parent; // The parent PApplet that we will render ourselves onto

   
    public BaseLauncher(PApplet p){
        parent = p;
        gameManager = new GameManager(parent);
    }
  
    public GameManager gameManager;
    public abstract void StartGame();
    
    public void UpdateAll(){
        gameManager.UpdateAll();
    }
    public void keyPressed(char key, int keyCode) {
    	gameManager.keyPressed(key, keyCode);
    }
    
    public void keyReleased(char key, int keyCode) {
    	gameManager.keyReleased(key, keyCode);
    }
    public void mousePressed() {
    	gameManager.mousePressed();
    }
    public void mouseClicked() {
    	gameManager.mouseClicked();
    }
   
}
