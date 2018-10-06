package game_engine2D;
import processing.core.PApplet;
/* Example of basic Launching game manager
 * This will be used when making a new game package like asteroids
 *  */
public class BaseLauncher {
    public PApplet parent; // The parent PApplet that we will render ourselves onto

   
    public BaseLauncher(PApplet p){
        parent = p;
    }
  
    public GameManager gameManager;
    public void StartGame(){
        gameManager = new GameManager(parent);
    }
    public void UpdateAll(){
        gameManager.UpdateAll();
    }

}
