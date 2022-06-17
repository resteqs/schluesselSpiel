import javax.swing.JPanel;

public class PausMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static PausMenu singleton = new PausMenu();
// Speichert das panel das in diesem Menu bearbeitet wird
    private JPanel panel;

	private PausMenu() {
		super(); 
	}

// Gibt das singleton zurück damit andere Klassen methoden aufrufen können
    public static PausMenu getInstance() {
        return singleton;
    }
    
// Methode die ein Panel erstellt
	public void menuAnzeigen() {
// erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// verändert das Hintergrundbild
		this.hintergrundEinstellen();
// fügt die Buttons hinzu
		this.buttonsErstellen();
//ruft methode auf die dann das pannel auf dem Bildschirmfenster anzeigen lässt
		BildschirmFenster.getInstance().addToMenu(panel);
	}

// Methode die das Hintergrundbild verändert
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
	
// Methode wird aufgerufen wenn einer der Buttons seinen Zustand ändert
	public void aktualiesiere(Observable veraendert) {
// Überprüft welcher Button gedrückt wurde:

		if (veraendert.getName() == "buttonResumGame") {
		}		
		if (veraendert.getName() == "buttonEndGame") {
// öffnet das "Game Over Menu"
			GameOverMenu.getInstance().menuAnzeigen();
		}		
	}
}
