import java.awt.*;

public class Spieler {
    //Koordinaten des Spielers
    private int xKoordinate;
    private int yKoordinate;

    //Model der Figur für die Hitbox und zugehörige Abweichungen der Animation von den Koordinaten
    private ImageWir figur;
    private int figurAbweichungOben;
    private int figurAbweichungLinks;

    //Bilder für die Animation 1
    private ImageWir[] animation;
    private ImageWir[] animationRechts;
    //Bilder für die Animation 2
    private ImageWir[] animation2;
    private ImageWir[] animationRechts2;
    //Hilfen für die richtige Grafik der Animation im nächsten Frame
    private int naechsteFigur;
    private boolean nachLinks;
    private int charakter;

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

        //Laden der Grafiken für die Animation 1
        animation       = new ImageWir[17];
        animationRechts = new ImageWir[17];

        for(int i = 0; i < animation.length; i++) {
            animation[i]       = new ImageWir("bilder/figur1/gehend_blau" + (i + 1) + ".png", 95, 150, xKoordinate, yKoordinate);
            animationRechts[i] = new ImageWir("bilder/figur1/gehend_blau_rechts" + (i + 1) + ".png", 95, 150, xKoordinate, yKoordinate);
        }

        //Laden der Grafiken für die Animation 2
        animation2       = new ImageWir[7];
        animationRechts2 = new ImageWir[7];

        for(int i = 0; i < animation2.length; i++) {
            animation2[i]       = new ImageWir("bilder/figur2/pixil-frame-" + i + ".png", 150, 150, xKoordinate, yKoordinate);
            animationRechts2[i] = new ImageWir("bilder/figur2/ProtagonistAnimationRight" + i + ".png", 150, 150, xKoordinate, yKoordinate);
        }

        //Setzen der Attribute für eine flüssige Animation
        naechsteFigur = 0;
        nachLinks     = true;

        //Setzt den Charakter und lädt das zugehörige Model, sodass die GameOverAbfrage auf den Charakter angepasst ist
        setCharakter(1);
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
    public void bewegen(Graphics graphics) {
        //Holt den Tastaturinput und setzt die entsprechende Distanz
        switch (Tastaturinput.getInstance().getSpieler()) {
            case "links":
                nachLinks();
                break;

            case "rechts":
                nachRechts();
                break;

            case "anhalten":
                anhalten();
                break;
        }

        //Setzt die x-Koordinate entsprechend der Distanz
        xKoordinate += distanz;

        //Setzt die Koordinaten des Spielers sollte er aus dem Fenster hinauslaufen zurück
        if(xKoordinate > Konstanten.SCREEN_WIDTH - figur.getBreite() - getFigurAbweichungLinks()) {
            xKoordinate = (int) Konstanten.SCREEN_WIDTH - figur.getBreite() - getFigurAbweichungLinks();
        } else if(xKoordinate < -getFigurAbweichungLinks()){
            xKoordinate = -getFigurAbweichungLinks();
        }

        //TEST: zeigt die Hitbox der Figur an
        //figur.zeichne(xKoordinate + getFigurAbweichungLinks(), yKoordinate + getFigurAbweichungOben(), graphics);

        //TEST: zur Sichtbarkeit, dass die Koordinaten des Spielers sich wirklich verändern
        //System.out.println(xKoordinate);

        //Zeichnet die Grafik des Spielers neu
        //Überprüft, welcher Charakter gezeichnet werden muss
        if(charakter == 1) {
            //überprüft die Richtung, in die die Grafik "schauen" soll und zeichnet diese
            if (nachLinks) {
                animation[naechsteFigur].zeichne(xKoordinate, yKoordinate, graphics);
            } else {
                animationRechts[naechsteFigur].zeichne(xKoordinate, yKoordinate, graphics);
            }
        } else if (charakter == 2) {
            //überprüft die Richtung, in die die Grafik "schauen" soll und zeichnet diese
            if (nachLinks) {
                animation2[naechsteFigur].zeichne(xKoordinate, yKoordinate, graphics);
            } else {
                animationRechts2[naechsteFigur].zeichne(xKoordinate, yKoordinate, graphics);
            }
        }

        //Lädt das nächste Bild der Animation je nach Bewegungszustand
        if(distanz == 0) {
            if(charakter == 1) {
                naechsteFigur = 0;
            } else if (charakter == 2) {
                naechsteFigur = 6;
            }

        } else {
            naechsteFigur++;
        }

        //Wählt wieder die Startfigur, wenn die Animation einmal durchlaufen wurde
        if(charakter == 1) {
            if (naechsteFigur >= animation.length) {
                naechsteFigur = 0;
            }
        } else if (charakter == 2) {
            if (naechsteFigur >= animation2.length) {
                naechsteFigur = 0;
            }
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

    /**
     * Setzt den Charakter neu, wenn der Charakter aber nicht vorhanden ist, wird Charakter 1 ausgewählt
     * zudem wird das Model entsprechend neu geladen
     * @param charakter nummer des Charakters (1: weiblich, 2: männlich)
     */
    public void setCharakter(int charakter) {
        this.charakter = charakter;

        switch (charakter) {
            case 1:
                figur                = new ImageWir("bilder/spieler_original.png", 61, 136, xKoordinate, yKoordinate);
                figurAbweichungOben  = 10;
                figurAbweichungLinks = 18;
                break;

            case 2:
                figur                = new ImageWir("bilder/spieler_original.png", 86, 150, xKoordinate, yKoordinate);
                figurAbweichungOben  = 0;
                figurAbweichungLinks = 32;
                break;

            default:
                setCharakter(1);
                break;
        }
    }

    /**
     * Gibt die Abweichung der Animation zu den Koordinaten von der Oberkante zurück
     * @return
     */
    public int getFigurAbweichungOben() {
        return figurAbweichungOben;
    }

    /**
     * Gibt die Abweichung der Animation zu den Koordinaten von der Linken Kante zurück
     * @return
     */
    public int getFigurAbweichungLinks() {
        return figurAbweichungLinks;
    }
}
