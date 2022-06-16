import java.awt.Dimension;
import java.util.concurrent.ThreadLocalRandom; // Für die randomZahl

import javax.swing.JFrame;

public class KeySpawner {
	private Key keys[];
	private int spawnTimerValue;
	private int spawnIteration;
	public KeySpawner() {
		keys = new Key[3];
		for(int i = 0; i < 3; i++) {
			keys[i] = new Key(0, 1500);
		}
	}
	public void spawn() {
		if(spawnTimerValue < 0) {
			spawnIteration ++;
			if(keys[spawnIteration % 3].getUse() == false) {
				keys[spawnIteration % 3].koordinatenSetzen(zufallZahl(), 100);
				spawnTimerValue = 50;
			}
		}
	}
	public int zufallZahl() {
		BildschirmFenster fenster = BildschirmFenster.getInstance();
        JFrame window             = fenster.getWindow();
        Dimension windowGroesse   = window.getSize();
        int randomNum = ThreadLocalRandom.current().nextInt(0, (int) windowGroesse.getWidth());
        return randomNum;
	}
	public void keysBewegen() {
		spawn();
		keys[0].bewegen();
		keys[1].bewegen();
		keys[2].bewegen();
	}
	public void spawnTimer() {
		spawnTimerValue --;
	}
}
