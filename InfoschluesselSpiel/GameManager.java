import javax.swing.*;
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
        hintergrund = new ImageWir("bilder/Konzept_dark_background.jpg", 1280, 720, 0, 0);

        //Erstellen eines Spielers
        spieler = new Spieler(440, 470);//Vorläufige Position wegen aktueller Fenstergröße
        spawner = new KeySpawner();
      

        //Starten des Timers
        zeit = new Stopwatch();
    }

    /**
     * Aktualisiert sämtliche Grafiken und Texte, die auf dem Spielfenster angezeigt werden
     */
    public void fensterAktualisieren() {
        spieler.bewegen();
        spawner.spawnTimer();
        spawner.keysBewegen();
        hintergrund.zeichne(0, 0);
        zeit.anzeigeAktualisieren();
    }


}
