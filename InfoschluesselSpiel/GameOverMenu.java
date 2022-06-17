import javax.swing.JPanel;

public class GameOverMenu extends MenuWir{
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static GameOverMenu singleton = new GameOverMenu();
// Speichert das Panel, das in diesem Menu bearbeitet wird
    private JPanel panel;

	private GameOverMenu() {
		super(); 
	}

// Gibt das Singleton zurück, damit andere Klassen davon Methoden aufrufen können
    public static GameOverMenu getInstance() {
        return singleton;
    }
    
// Methode, die das Panel erstellt
	public void menuAnzeigen() {
// Erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// Verändert das Hintergrundbild
		this.hintergrundEinstellen();
// Fügt die Buttons hinzu
		this.buttonsErstellen();
// Ruft die Methode auf, die dann das Panel auf dem Bildschirmfenster anzeigen lässt
		BildschirmFenster.getInstance().addToMenu(panel);
	}

// Methode, die das Hintergrundbild verändert
	protected void hintergrundEinstellen() {
				
	}
	
// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "Zurück zum Hauptmenu"
		ButtonWir buttonBackToMainMenu = new ButtonWir(panel, "backToMainMenu", "<-- Zurück zum Hauptmenü", 75, 500, 200, 100);
// Registriert sich seblst als Observer beim Button "Zurück zum Hauptmenu"
		buttonBackToMainMenu.regrestrireObserver(this);
	}
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand ändert
	public void aktualiesiere(Observable veraendert) {
// Überprüft welcher Button gedrückt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// öffnet das Hauptmenü.
			MainMenu.getInstance().menuAnzeigen();
		}		
	}
}
