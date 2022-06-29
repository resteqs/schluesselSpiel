import javax.swing.JPanel;

public class PausMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static PausMenu singleton = new PausMenu();
// Speichert das panel das in diesem Menu bearbeitet wird
    private JPanel panel;

	private PausMenu() {
		super(); 
	
	}

// Gibt das singleton zur�ck damit andere Klassen methoden aufrufen k�nnen
    public static PausMenu getInstance() {
        return singleton;
    }
    
// Methode die ein Panel erstellt
	public void menuAnzeigen() {
// erstellt das Panel
		panel = new JPanel();
		panel.setLayout(null);
// f�gt die Buttons hinzu
		this.buttonsErstellen();
// ver�ndert das Hintergrundbild
		this.hintergrundEinstellen();
//ruft methode auf die dann das panel auf dem Bildschirmfenster anzeigen l�sst
		BildschirmFenster.getInstance().addToMenu(panel);
	}

// Methode die das Hintergrundbild ver�ndert
	public void hintergrundEinstellen() {
		ImageWir hintergrund = new ImageWir("bilder/PauseScreen.jpg", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);
		panel.add(hintergrund.getjLabel());
	}
	
// Methode, die die Buttons erstellt.
	protected void buttonsErstellen() {
// Erstellt Button "Spiel Fortsetzen"
		ButtonWir buttonResumGame = new ButtonWir(panel, "buttonResumGame", "Spiel Fortsetzen", 300, 500, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Fortsetzen"
		buttonResumGame.regrestrireObserver(this);
// Erstellt Button "Spiel Beenden"
		ButtonWir buttonEndGame = new ButtonWir(panel, "buttonEndGame", "Spiel Beenden", Konstanten.SCREEN_WIDTH - 300 - 200, 500, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Beenden"
		buttonEndGame.regrestrireObserver(this);
	}
	
// Methode wird aufgerufen wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// �berpr�ft welcher Button gedr�ckt wurde:

		if (veraendert.getName() == "buttonResumGame") {
			 GameManager gameManager = GameManager.getInstance();
			 gameManager.startStop();
		}		
		if (veraendert.getName() == "buttonEndGame") {
// �ffnet das "Game Over Menu"
			GameOverMenu.getInstance().menuAnzeigen();
			GameManager.getInstance().setGame(false);
		}
	}
}
