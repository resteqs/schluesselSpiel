import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom; // Für die randomZahl

import javax.swing.JFrame;

public class KeySpawner {
	private Key keys[];
	private int spawnTimerValue = -1;
	private int spawnIteration;
	private int startCountdown; 
	private Dimension windowGroesse;
	public KeySpawner(){ // erzeugt 7 inaktive Schlüsseln die auf Spawn warten
		keys = new Key[7];
		for(int i = 0; i < 7; i++) {
			keys[i] = new Key(0, 1500);
		}
		BildschirmFenster fenster = BildschirmFenster.getInstance();
        JFrame window             = fenster.getWindow();
        windowGroesse   = window.getSize();
	}
	public void spawn() {
		if(startCountdown == 0) {
			startCountdown ++;
			spawnTimerValue = 100;
		}
		// Wenn der mindestzeitabstand zwischen spawns erreicht wurde
		if(spawnTimerValue < 0) {
			spawnIteration ++; 
			if(keys[spawnIteration % 7].getUse() == false) // wird der nächste Schlüssel
				// aus dem Array genommen und auf inaktivität überprüft
				{ // Der inaktive Key bekommt zufällige Koordinaten
				keys[spawnIteration % 7].koordinatenSetzen(zufallZahl(), 10);
				spawnTimerValue = 10; // Mindestzeitabstand zwischen Spawns in FPS
			}
		}
	}
	public int zufallZahl() { // erstellt eine zufällige Zahl zwischen 0 und Fensterbreite - Schlüsselbreite
        int randomNum = ThreadLocalRandom.current().nextInt(0, (int) windowGroesse.getWidth()-100);
        return randomNum;
	}
	public void keysBewegen(Graphics graphics) //siehe Klasse Key
	{
		spawn();
		for(int j = 0; j <7; j++) {
			keys[j].bewegen(graphics);
		}
	}
	public void spawnTimer() // reduziert den "Timer" um 1 pro Frame
	{
		spawnTimerValue --;
	}

	public Key[] getKeys() {
		return keys;
	}
	public void startCountdownReset() {
		startCountdown = 0;
	}
}
