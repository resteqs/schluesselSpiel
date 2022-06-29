import javax.swing.JPanel;

public class GameOverMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static GameOverMenu singleton = new GameOverMenu();
// Speichert das Panel, das in diesem Menu bearbeitet wird
    private JPanel panel;

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
// Ver�ndert das Hintergrundbild
		this.hintergrundEinstellen();
// F�gt die Buttons hinzu
		this.buttonsErstellen();
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
	}
}
