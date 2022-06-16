import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager {
    //Singleton-Pattern, dass nur ein GameManager existiert
    private static GameManager singleton = new GameManager();
    //Referenz auf die Spielfigur des Spiels
    private Spieler spieler;
    //Referenz auf den Hintergrund im Spiel
    private ImageWir hintergrund;
    //Referenz auf die vergangene Spielzeit
    private Stopwatch zeit;

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
        hintergrund = new ImageWir("bilder/Konzept_dark_background.jpg", 1920, 1080, 0, 0);

        //Erstellen eines Spielers
        spieler = new Spieler(960, 850);//Vorläufige Position wegen aktueller Fenstergröße

        //Starten des Timers
        zeit = new Stopwatch();
    }

    /**
     * Aktualisiert sämtliche Grafiken und Texte, die auf dem Spielfenster angezeigt werden
     */
    public void fensterAktualisieren() {
        spieler.bewegen();
        hintergrund.zeichne(0, 0);
        zeit.anzeigeAktualisieren();
    }
}
