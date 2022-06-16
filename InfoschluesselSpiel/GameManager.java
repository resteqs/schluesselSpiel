import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager {
    //Singleton-Pattern, dass nur ein GameManager existiert
    private static GameManager singleton = new GameManager();
    //Referenz auf die Spielfigur des Spiels
    private Spieler spieler;
    private KeySpawner spawner;
    //Referenz auf den Hintergrund im Spiel
    private ImageWir hintergrund;
    //Referenz auf die vergangene Spielzeit
    private Stopwatch zeit;

    //DoubleBuffer Attribute
    private Image doubleBufferImage;
    private Graphics doubleBufferGraphics;

    private GameManager(){}

    /**
     * Gibt das Singleton des GameManagers zurück
     * @return
     */
    public static GameManager getInstance() {
        return singleton;
    }

    /**
     * Startet das Spiel
     */
    public void spielStarten() {
        //TEST: Erstellt ein Image für den Hintergrund um diesen anzuzeigen
        hintergrund = new ImageWir("bilder/Konzept_dark_background.jpg", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);

        //Erstellen eines Spielers
        spieler = new Spieler(440, 470);//Vorläufige Position wegen aktueller Fenstergröße

        spawner = new KeySpawner();

        //Starten des Timers
        zeit = new Stopwatch();
    }

    /**
     * Aktualisiert sämtliche Grafiken und Texte, die auf dem Spielfenster angezeigt werden
     */
    public void fensterAktualisieren(Graphics g) {
        //Erstellt ein Bild des aktuellen Fensters
        if(doubleBufferImage == null) {
            //Erfragt die Fensterdaten
            BildschirmFenster fenster = BildschirmFenster.getInstance();
            JFrame window             = fenster.getWindow();

            //Kopiert die aktuelle Grafik
            doubleBufferImage    = window.createImage(Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT);
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }

        //Rendert neue Grafiken
        renderGrafiken(doubleBufferGraphics);

        //Zeichnet die neue Grafik
        g.drawImage(doubleBufferImage, 0, 0, Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, null);

        //Zählt die Zeit des Spawners herunter
        spawner.spawnTimer();
    }

    /**
     * Rendert die Grafiken für den nächsten Frame
     * @param g
     */
    public void renderGrafiken(Graphics g) {
        hintergrund.zeichne(0, 0, g);
        spieler.bewegen(g);
        spawner.keysBewegen(g);
        zeit.anzeigeAktualisieren(g);
    }
}
