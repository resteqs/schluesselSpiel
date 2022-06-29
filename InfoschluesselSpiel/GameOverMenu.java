import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameOverMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static GameOverMenu singleton = new GameOverMenu();
// Speichert das Panel, das in diesem Menu bearbeitet wird
    private JPanel panel;
    
    
    JTextField tfName; 
	String name;

    

	private GameOverMenu() {
		super(); 
	}

// Gibt das Singleton zurï¿½ck, damit andere Klassen davon Methoden aufrufen kï¿½nnen
    public static GameOverMenu getInstance() {
        return singleton;
    }
    
// Methode, die das Panel erstellt
	public void menuAnzeigen() {
// Erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// Fï¿½gt die Buttons hinzu
		this.buttonsErstellen();
		
		this.eingabefeldErstellen();
// Verï¿½ndert das Hintergrundbild
		this.hintergrundEinstellen();
// Ruft die Methode auf, die dann das Panel auf dem Bildschirmfenster anzeigen lï¿½sst
		BildschirmFenster.getInstance().addToMenu(panel);
//Stoppt die Spielmusik (Ist noch die Menu Musik als Platzhalter)
		MusicPlayer.StopClip();
	}

// Methode, die das Hintergrundbild verï¿½ndert
	protected void hintergrundEinstellen() {
		ImageWir hintergrund = new ImageWir("bilder/GameoverScreen.jpg", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);
		panel.add(hintergrund.getjLabel());
	}
	
// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "Zurï¿½ck zum Hauptmenu"
		ButtonWir buttonBackToMainMenu = new ButtonWir(panel, "backToMainMenu", "<-- Zurï¿½ck zum Hauptmenï¿½", 75, 550, 200, 100);
// Registriert sich seblst als Observer beim Button "Zurï¿½ck zum Hauptmenu"
		buttonBackToMainMenu.regrestrireObserver(this);
// Erstellt Button "Nochmal versuchen"
		ButtonWir buttonResumeGame = new ButtonWir(panel, "resumeGame", "Nochmal versuchen", Konstanten.SCREEN_WIDTH - 75 - 200, 550, 200, 100);
// Registriert sich selbst als Observer beim Button "Nochmal versuchen"
		buttonResumeGame.regrestrireObserver(this);
		
// Erstellt Button "Nochmal versuchen"
		ButtonWir buttonNameEingegeben = new ButtonWir(panel, "nameEingegeben", "Fertig", 650, 200, 200, 50);
// Registriert sich selbst als Observer beim Button "Nochmal versuchen"
		buttonNameEingegeben.regrestrireObserver(this);

	}
	
	public void eingabefeldErstellen() {
        tfName = new JTextField("Name", 15);
        // Schriftfarbe wird gesetzt
        tfName.setForeground(Color.BLUE);
        // Hintergrundfarbe wird gesetzt
        tfName.setBackground(Color.white);
        // Groese und position wird gesetzt
        tfName.setBounds(400, 200, 200, 50);
        // Textfeld wird Panel hinzugefügt
        panel.add(tfName);
	}
	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand ï¿½ndert
	public void aktualiesiere(Observable veraendert) {
// ï¿½berprï¿½ft welcher Button gedrï¿½ckt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// ï¿½ffnet das Hauptmenï¿½.
			MainMenu.getInstance().menuAnzeigen();
		}
		if(veraendert.getName() == "resumeGame") {
			GameManager.getInstance().spielStarten();
			BildschirmFenster.getInstance().removeMenu();
		}
		if(veraendert.getName() == "nameEingegeben") {
			// Wenn der Button gedrückt wurde wird der abgefragt welcher text im Feld steht
			name = tfName.getText();
			// Die Stopuhr wird gefragt welche Punktzahl ereicht wurde (Ja es ist eklig, aber die Klasse Stopwatch ist kein Singelton (weis auch nicht warum))
			String score = Double.toString(GameManager.getInstance().stopwatchGeben().currentTimeGeben());
			// Gibt forübergehend die Werte aus
			System.out.println(name);
			System.out.println(score);
		}
	}
}
