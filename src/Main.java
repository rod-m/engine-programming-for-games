import processing.core.PApplet;
import simple_platformer.Launcher;
public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	public Launcher launcher;
	public void setup() {
		background(0);
		launcher = new Launcher(this);
		launcher.StartGame();
	}
	public void draw() {
		launcher.UpdateAll();
	}
	public void settings() {
		size(640,480);
	}
	// event handling
	public void keyPressed()    { launcher.keyPressed(key, keyCode); }
//	void keyReleased()   { activeScreen.keyReleased(key, keyCode); }
//	void mouseMoved()    { activeScreen.mouseMoved(mouseX, mouseY); }
//	void mousePressed()  { SoundManager.clicked(mouseX,mouseY); activeScreen.mousePressed(mouseX, mouseY, mouseButton); }
//	void mouseDragged()  { activeScreen.mouseDragged(mouseX, mouseY, mouseButton); }
//	void mouseReleased() { activeScreen.mouseReleased(mouseX, mouseY, mouseButton); }
//	void mouseClicked()  { activeScreen.mouseClicked(mouseX, mouseY, mouseButton); }

}
