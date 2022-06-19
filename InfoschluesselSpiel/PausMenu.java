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
// erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// ver�ndert das Hintergrundbild
		this.hintergrundEinstellen();
// f�gt die Buttons hinzu
		this.buttonsErstellen();
//ruft methode auf die dann das pannel auf dem Bildschirmfenster anzeigen l�sst
		BildschirmFenster.getInstance().addToMenu(panel);
	}

// Methode die das Hintergrundbild ver�ndert
	public void hintergrundEinstellen() {
		// TODO Auto-generated method stub
		
	}
	
// Methode, die die Buttons erstellt.
	protected void buttonsErstellen() {
// Erstellt Button "Spiel Fortsetzen"
		ButtonWir buttonResumGame = new ButtonWir(panel, "buttonResumGame", "Spiel Fortsetzen", 550, 100, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Fortsetzen"
		buttonResumGame.regrestrireObserver(this);
// Erstellt Button "Spiel Beenden"
		ButtonWir buttonEndGame = new ButtonWir(panel, "buttonEndGame", "Spiel Beenden", 550, 300, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Beenden"
		buttonEndGame.regrestrireObserver(this);
	}	
	
// Methode wird aufgerufen wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// �berpr�ft welcher Button gedr�ckt wurde:

		if (veraendert.getName() == "buttonResumGame") {
			 GameManager gameManager = GameManager.getInstance();
			 gameManager.startStop();
			 BildschirmFenster.getInstance().removeMenu();
			 
		}		
		if (veraendert.getName() == "buttonEndGame") {
// �ffnet das "Game Over Menu"
			GameOverMenu.getInstance().menuAnzeigen();
		}		
	}
}
