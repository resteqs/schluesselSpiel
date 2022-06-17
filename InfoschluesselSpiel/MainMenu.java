import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends MenuWir{
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static MainMenu singleton = new MainMenu();
// Speichert das panel das in diesem Menu bearbeitet wird
    private JPanel panel;
	
	private MainMenu() {
		super(); 
	}

// Gibt das singleton zurück damit andere Klassen methoden aufrufen können
    public static MainMenu getInstance() {
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
	protected void hintergrundEinstellen() {
		// TODO Auto-generated method stub
		
	}	

// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "SpielStarten"
		ButtonWir buttonSpielStarten = new ButtonWir(panel, "ButtonSpielStarten", "Spiel Starten", 550, 100, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Starten"
		buttonSpielStarten.regrestrireObserver(this);
// Erstellt Button "Highscore Liste"
		ButtonWir buttonHighScoreMenu = new ButtonWir(panel, "ButtonHighScoreMenu", "Highscore Liste", 550, 300, 200, 100);
// Registriert sich seblst als Observer bei Button "Highscore Liste"
		buttonHighScoreMenu.regrestrireObserver(this);
	}	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand ändert
	public void aktualiesiere(Observable veraendert) {
// Überprüft welcher Button gedrückt wurde:
		
		if (veraendert.getName() == "ButtonSpielStarten") {
// Startet das Spiel
			GameManager.getInstance().spielStarten();
		}
		if (veraendert.getName() == "ButtonHighScoreMenu") {
// Öffnet das Highscore Menü
			HighScoreMenu.getInstance().menuAnzeigen();
		}
	}
}
