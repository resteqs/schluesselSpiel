import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;

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
    private boolean isPaused = false;
    private GameOverDetector checker;
   

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
        //Erstellt ein Image für den Hintergrund, um diesen anzuzeigen
        hintergrund = new ImageWir("bilder/Final_background_animated.gif", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);

        //Erstellen eines Spielers
        spieler = new Spieler(600, 510);//Vorläufige Position wegen aktueller Fenstergröße

        spawner = new KeySpawner();
        spawner.startCountdownReset();

        //Starten des Timers
        zeit = new Stopwatch();

        checker = new GameOverDetector();

        isPaused = false;
        
    }

    /**
     * Aktualisiert sämtliche Grafiken und Texte, die auf dem Spielfenster angezeigt werden
     * @param graphics
     */
    public void fensterAktualisieren(Graphics graphics) {
        //Erstellt ein Bild des aktuellen Fensters
        if(doubleBufferImage == null) {
            //Erfragt die Fensterdaten
            BildschirmFenster fenster = BildschirmFenster.getInstance();
            JFrame window             = fenster.getWindow();

            //Kopiert die aktuelle Grafik
            doubleBufferImage    = window.createImage(Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT);
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }

        if(!isPaused) // Das Spiel läuft nur dann, wenn das Spiel nicht pausiert ist
        {
            //Rendert neue Grafiken
            renderGrafiken(doubleBufferGraphics);

            //Zeichnet die neue Grafik
            graphics.drawImage(doubleBufferImage, 0, 0, Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, null);

            //Zählt die Zeit des Spawners herunter
            spawner.spawnTimer();

            checker.check(spawner.getKeys(), spieler, zeit);
        }
    }

    /**
     * Rendert die Grafiken für den nächsten Frame
     * @param graphics
     */
    public void renderGrafiken(Graphics graphics) {
        hintergrund.zeichne(0, 0, graphics);
        spieler.bewegen(graphics);
        spawner.keysBewegen(graphics);
        zeit.anzeigeAktualisieren(graphics);
    }

    public void startStop() //Eine Funktion die das Spiel je nach aktuellen Zustand pausiert, oder forstetzt
    {
		if(isPaused) {
			isPaused = false; //Setzt das Spielgeschehen fort ; Siehe: fensterAktualiesieren()
            BildschirmFenster.getInstance().removeMenu();
			zeit.timerStarten();
		}else {
			isPaused = true; // Pausiert das Spielgeschehen
			PausMenu.getInstance().menuAnzeigen(); //Öffnet das Menu
			zeit.timerStoppen();
		}
}
}
