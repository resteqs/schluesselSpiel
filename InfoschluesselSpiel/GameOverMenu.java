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

// Gibt das Singleton zur�ck, damit andere Klassen davon Methoden aufrufen k�nnen
    public static GameOverMenu getInstance() {
        return singleton;
    }
    
// Methode, die das Panel erstellt
	public void menuAnzeigen() {
// Erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// F�gt die Buttons hinzu
		this.buttonsErstellen();
		
		this.eingabefeldErstellen();
// Ver�ndert das Hintergrundbild
		this.hintergrundEinstellen();
// Ruft die Methode auf, die dann das Panel auf dem Bildschirmfenster anzeigen l�sst
		BildschirmFenster.getInstance().addToMenu(panel);
//Stoppt die Spielmusik (Ist noch die Menu Musik als Platzhalter)
		MusicPlayer.StopClip();
	}

// Methode, die das Hintergrundbild ver�ndert
	protected void hintergrundEinstellen() {
		ImageWir hintergrund = new ImageWir("bilder/GameoverScreen.jpg", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);
		panel.add(hintergrund.getjLabel());
	}
	
// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "Zur�ck zum Hauptmenu"
		ButtonWir buttonBackToMainMenu = new ButtonWir(panel, "backToMainMenu", "<-- Zur�ck zum Hauptmen�", 75, 550, 200, 100);
// Registriert sich seblst als Observer beim Button "Zur�ck zum Hauptmenu"
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
        // Textfeld wird Panel hinzugef�gt
        panel.add(tfName);
	}
	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// �berpr�ft welcher Button gedr�ckt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// �ffnet das Hauptmen�.
			MainMenu.getInstance().menuAnzeigen();
		}
		if(veraendert.getName() == "resumeGame") {
			GameManager.getInstance().spielStarten();
			BildschirmFenster.getInstance().removeMenu();
		}
		if(veraendert.getName() == "nameEingegeben") {
			// Wenn der Button gedr�ckt wurde wird der abgefragt welcher text im Feld steht
			name = tfName.getText();
			// Die Stopuhr wird gefragt welche Punktzahl ereicht wurde (Ja es ist eklig, aber die Klasse Stopwatch ist kein Singelton (weis auch nicht warum))
			String score = Double.toString(GameManager.getInstance().stopwatchGeben().currentTimeGeben());
			// Gibt for�bergehend die Werte aus
			System.out.println(name);
			System.out.println(score);
		}
	}
}
