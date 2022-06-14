import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager {
    //Singleton-Pattern, dass nur ein GameManager existiert
    private static GameManager singleton = new GameManager();
    //Referenz auf die Spielfigur des Spiels
    private Spieler spieler;

    private GameManager(){}

    /**
     * Gibt das Singleton des GameManagers zurück
     * @return
     */
    public static GameManager getInstance() {
        return singleton;
    }

    //Ab hier für Testzwecke erstellt, aber zur Sichtbarkeit der Funktion der Steuerung erstmal notwendig
    //Person, die für die Zeit zuständig ist, bitte noch überarbeiten
    private Timer timer;

    /**
     * Startet das Spiel
     */
    public void spielStarten() {
        //Erstellen eines Spielers
        spieler = new Spieler(350, 700);//Vorläufige Position wegen aktueller Fenstergröße

        //Timer der nach 20ms die Bewegung des Spielers aktualisiert
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spieler.bewegen();
            }
        });

        //startet den timer
        timer.start();
    }
    //Ende Bereich für Testzwecke
}
