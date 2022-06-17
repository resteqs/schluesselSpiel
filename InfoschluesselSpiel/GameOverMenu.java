import javax.swing.JPanel;

public class GameOverMenu extends MenuWir{
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
	}

// Methode, die das Hintergrundbild ver�ndert
	protected void hintergrundEinstellen() {
				
	}
	
// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "Zur�ck zum Hauptmenu"
		ButtonWir buttonBackToMainMenu = new ButtonWir(panel, "backToMainMenu", "<-- Zur�ck zum Hauptmen�", 75, 500, 200, 100);
// Registriert sich seblst als Observer beim Button "Zur�ck zum Hauptmenu"
		buttonBackToMainMenu.regrestrireObserver(this);
	}
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// �berpr�ft welcher Button gedr�ckt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// �ffnet das Hauptmen�.
			MainMenu.getInstance().menuAnzeigen();
		}		
	}
}
