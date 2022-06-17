import java.awt.*;

import javax.swing.JFrame;

public class Key{
	private int xKoordinate;
	private int yKoordinate;
	private boolean inUse;
	private int geschwindigkeit = 10;
	private ImageWir graphik;
		Key(int x, int y){
			xKoordinate = x;
			yKoordinate = y;
			graphik = new ImageWir("bilder/key_example.png", 100, 100, xKoordinate, yKoordinate);
			inUse = false;
			
		}// inaktives Schlüssel wird aktiviert und auf die Zufälligen x Koordinaten gebracht
		public void koordinatenSetzen(int x, int y) {
			xKoordinate = x;
			yKoordinate = y;
			inUse = true;
		}
		public boolean getUse() {
			return inUse;
		}
		public void bewegen(Graphics g) {
	        
	       

	        //Erfragt die Größe des Spielfensters
	        BildschirmFenster fenster = BildschirmFenster.getInstance();
	        JFrame window             = fenster.getWindow();
	        Dimension windowGroesse   = window.getSize();

	        //Wir wollen nur aktive Schlüsseln nach unten fallen lassen
	        // Wenn der Schlüssel den Boden berührt wird er nach y=1500 "teleportiert"
	        // und wartet bis KeySpawner den wieder einsetzt
	        if(inUse == true) {
	        	if(yKoordinate > windowGroesse.getHeight() - graphik.getHoehe()) {
		            yKoordinate = 1500; inUse = false;
		        } 
	        	yKoordinate += 10; //ansonsten wird er pro Frame um 10 Einheiten nach unten verschoben
	        }
			//Zeichnet die Grafik des Schlüssels neu
	        graphik.zeichne(xKoordinate, yKoordinate, g);
	    }

	public int getxKoordinate() {
		return xKoordinate;
	}

	public int getyKoordinate() {
		return yKoordinate;
	}

	public ImageWir getGraphik() {
		return graphik;
	}
}

