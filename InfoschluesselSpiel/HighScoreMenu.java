import javax.swing.JPanel;

public class HighScoreMenu extends MenuWir{
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static HighScoreMenu singleton = new HighScoreMenu();
 // Speichert das Panel, das in diesem Menu bearbeitet wird
    private JPanel panel;

	private HighScoreMenu() {
		super(); 
	}

// Gibt das Singleton zurück, damit andere Klassen Methoden davon aufrufen können
    public static HighScoreMenu getInstance() {
        return singleton;
    }
    
// Methode, die ein Panel erstellt
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
// Registriert sich seblst als Observer für den Button "Zurück zum Hauptmenü"
		buttonBackToMainMenu.regrestrireObserver(this);
	}	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand ändert
	public void aktualiesiere(Observable veraendert) {
// Überprüft welcher Button gedrückt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// öffnet das Hauptmenü
			MainMenu.getInstance().menuAnzeigen();
		}
	}
}
