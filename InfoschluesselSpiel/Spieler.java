import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Spieler {
    //Koordinaten des Spielers
    private int xKoordinate;
    private int yKoordinate;

    //Model der Figur für Größe
    private ImageWir figur;
    //Bilder für die Animation
    private ImageWir[] animation;
    private ImageWir[] animationRechts;
    //Hilfen für die richtige Grafik der Animation im nächsten Frame
    private int naechsteFigur;
    private boolean nachLinks;

    //Distanz die zurückgelegt wurde, sodass die Koordinaten nur beim "erneuern" des Spielfensters verändert werden
    private int distanz;

    //Geschwindigikeit mit der sich der Spieler bewegt (kann noch angepasst werden)
    private final int geschwindigkeit = 10;

    /**
     * Erstellt einen Spieler an den gegebenen Koodinaten
     * @param x x-Koordinate des Spielers
     * @param y y-Koordinate des Spielers
     */
    public Spieler(int x, int y) {
        //Setzt den Spieler an die entsprechende Stelle im Spielfenster
        xKoordinate = x;
        yKoordinate = y;

        distanz = 0;

        //Lädt das Figur Model
        figur = new ImageWir("bilder/figur1/gehend_blau1.png", 95, 150, xKoordinate, yKoordinate);

        //Laden der Grafiken für die Animation
        animation       = new ImageWir[17];
        animationRechts = new ImageWir[17];

        for(int i = 0; i < animation.length; i++) {
            animation[i]       = new ImageWir("bilder/figur1/gehend_blau" + (i + 1) + ".png", 95, 150, xKoordinate, yKoordinate);
            animationRechts[i] = new ImageWir("bilder/figur1/gehend_blau_rechts" + (i + 1) + ".png", 95, 150, xKoordinate, yKoordinate);
        }

        naechsteFigur = 0;
        nachLinks     = true;

        keyListenerHinzufuegen();
    }

    /**
     * Fügt den KeyListener zum Spielfenster hinzu, dass der Spieler auf Tastatureingaben reagiert
     */
    private void keyListenerHinzufuegen() {
        BildschirmFenster fenster = BildschirmFenster.getInstance();
        JFrame window             = fenster.getWindow();

        window.addKeyListener(new KeyAdapter() {
            //Reagiert so lange die Pfeiltasten nach links/rechts gedrückt werden
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case VK_LEFT:
                        nachLinks();
                        break;

                    case VK_RIGHT:
                        nachRechts();
                        break;
                }
            }

            //Reagiert, wenn die Pfeiltasten losgelassen werden
            @Override
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case VK_LEFT:
                    case VK_RIGHT:
                        anhalten();
                        break;
                }
            }
        });
    }

    /**
     * Ändert die Distanz, dass der Spieler nach links bewegt wird
     */
    private void nachLinks() {
        distanz   = -geschwindigkeit;
        nachLinks = true;
    }

    /**
     * Ändert die Distanz, dass der Spieler nach rechts bewegt wird
     */
    private void nachRechts() {
        distanz   = geschwindigkeit;
        nachLinks = false;
    }

    /**
     * Ändert die Distanz, dass der Spieler stehen bleibt
     */
    private void anhalten() {
        distanz = 0;
    }

    /**
     * Setzt die Koordinaten entsprechend der zurückgelegten Distanz und aktualisiert die Grafik
     * Wird beim Aktualisieren des Spielfensters aufgerufen
     */
    public void bewegen(Graphics g) {
        //Setzt die x-Koordinate entsprechend der Distanz
        xKoordinate += distanz;

        //Setzt die Koordinaten des Spielers sollte er aus dem Fenster hinauslaufen zurück
        if(xKoordinate > Konstanten.SCREEN_WIDTH - figur.getBreite()) {
            xKoordinate = (int) Konstanten.SCREEN_WIDTH - figur.getBreite();
        } else if(xKoordinate < 0){
            xKoordinate = 0;
        }

        //TEST: zur Sichtbarkeit, dass die Koordinaten des Spielers sich wirklich verändern
        //System.out.println(xKoordinate);

        //Zeichnet die Grafik des Spielers neu
        //überprüft die Richtung in die die Grafik "schauen" soll und zeichnet diese
        if(nachLinks) {
            animation[naechsteFigur].zeichne(xKoordinate, yKoordinate, g);
        } else {
            animationRechts[naechsteFigur].zeichne(xKoordinate, yKoordinate, g);
        }

        //Lädt das nächste Bild der Animation je nach Bewegungszustand
        if(distanz == 0) {
            naechsteFigur = 0;
        } else {
            naechsteFigur++;
        }

        //Wählt wieder die Startfigur, wenn die Animation einmal durchlaufen wurde
        if(naechsteFigur >= animation.length) {
            naechsteFigur = 0;
        }
    }

    /**
     * Gibt die xKoordinate des Spielers zurück
     * @return
     */
    public int getxKoordinate() {
        return xKoordinate;
    }

    /**
     * Gibt die yKoordinate des Spielers zurück
     * @return
     */
    public int getyKoordinate() {
        return yKoordinate;
    }

    /**
     * Gibt die Figur des Spielers zurück
     * @return
     */
    public ImageWir getFigur() {
        return figur;
    }
}
