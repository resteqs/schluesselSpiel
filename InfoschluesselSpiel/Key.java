import java.awt.Dimension;

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
			graphik = new ImageWir("bilder/spieler.png", 100, 100, xKoordinate, yKoordinate);
			inUse = false;
			
		}
		public void koordinatenSetzen(int x, int y) {
			xKoordinate = x;
			yKoordinate = y;
			inUse = true;
		}
		public boolean getUse() {
			return inUse;
		}
		public void bewegen() {
	        //Setzt die x-Koordinate entsprechend der Distanz
	       

	        //Erfragt die Größe des Spielfensters, um dafür zu sorgen, dass der Spieler nicht aus dem Bildschirm läuft
	        BildschirmFenster fenster = BildschirmFenster.getInstance();
	        JFrame window             = fenster.getWindow();
	        Dimension windowGroesse   = window.getSize();

	        //Setzt die Koordinaten des Spielers sollte er aus dem Fenster hinauslaufen zurück
	        if(inUse == true) {
	        	if(yKoordinate > windowGroesse.getHeight() - graphik.getHoehe()) {
		            yKoordinate = 1500; inUse = false;
		        } 
	        	yKoordinate += 10;
	        }
	         


	        

			//Zeichnet die Grafik des Spielers neu
	        graphik.zeichne(xKoordinate, yKoordinate);
	    }
	}

