import java.awt.*;
import java.util.concurrent.ThreadLocalRandom; // Für die randomZahl

import javax.swing.JFrame;

public class KeySpawner {
	private Key keys[];
	private int spawnTimerValue = -1;
	private int spawnIteration;
	private int startCountdown; 
	public KeySpawner(){ // erzeugt 7 inaktive Schlüsseln die auf Spawn warten
		keys = new Key[10];
		for(int i = 0; i < 10; i++) {
			keys[i] = new Key(0, 1500);
		}
	}
	public void spawn() {
		if(startCountdown == 0) {
			startCountdown ++;
			spawnTimerValue = 100;
		}
		// Wenn der mindestzeitabstand zwischen spawns erreicht wurde
		if(spawnTimerValue < 0) {
			spawnIteration ++; 
			if(keys[spawnIteration % 10].getUse() == false) // wird der nächste Schlüssel
				// aus dem Array genommen und auf inaktivität überprüft
				{ // Der inaktive Key bekommt zufällige Koordinaten
				keys[spawnIteration % 10].koordinatenSetzen(zufallZahl(), 10);
				spawnTimerValue = 5; // Mindestzeitabstand zwischen Spawns in mSek
			}
		}
	}
	public int zufallZahl() { // erstellt eine zufällige Zahl zwischen 0 und Fensterbreite - Schlüsselbreite
		BildschirmFenster fenster = BildschirmFenster.getInstance();
        JFrame window             = fenster.getWindow();
        Dimension windowGroesse   = window.getSize();
        int randomNum = ThreadLocalRandom.current().nextInt(0, (int) windowGroesse.getWidth()-100);
        return randomNum;
	}
	public void keysBewegen(Graphics graphics) //siehe Klasse Key
	{
		spawn();
		for(int j = 0; j <10; j++) {
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
