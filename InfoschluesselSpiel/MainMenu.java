import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static MainMenu singleton = new MainMenu();
// Speichert das panel, das in diesem Menu bearbeitet wird
    private JPanel panel;
	
	private MainMenu() {
		super(); 
	}

// Gibt das singleton zur�ck damit andere Klassen methoden aufrufen k�nnen
    public static MainMenu getInstance() {
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
	protected void hintergrundEinstellen() {
		ImageWir hintergrund = new ImageWir("bilder/Titlescreen.gif", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);
		panel.add(hintergrund.getjLabel());
	}	

// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "SpielStarten"
		ButtonWir buttonSpielStarten = new ButtonWir(panel, "ButtonSpielStarten", "Spiel Starten", 100, 200, 200, 100);
// Registriert sich seblst als Observer beim Button "Spiel Starten"
		buttonSpielStarten.regrestrireObserver(this);
// Erstellt Button "Highscore Liste"
		ButtonWir buttonHighScoreMenu = new ButtonWir(panel, "ButtonHighScoreMenu", "Highscore Liste", 100, 400, 200, 100);
// Registriert sich seblst als Observer bei Button "Highscore Liste"
		buttonHighScoreMenu.regrestrireObserver(this);
// Erstellt Button "Spiel beenden"
		ButtonWir buttonSpielBeenden = new ButtonWir(panel, "ButtonSpielBeenden", "Spiel beenden", Konstanten.SCREEN_WIDTH - 100 - 200, 400, 200, 100);
// Registriert sich selbst als Observer beim Button "Spiel Beenden"
		buttonSpielBeenden.regrestrireObserver(this);
	}	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// Ueberprueft welcher Button gedrueckt wurde:
		if (veraendert.getName() == "ButtonSpielStarten") {
//Sorgt dafür, dass das Menü beim Spielstart verschwindet
			BildschirmFenster.getInstance().removeMenu();
// Startet das Spiel
			GameManager.getInstance().spielStarten();
		}
		if (veraendert.getName() == "ButtonHighScoreMenu") {
// �ffnet das Highscore Men�
			HighScoreMenu.getInstance().menuAnzeigen();
		}
		if (veraendert.getName() == "ButtonSpielBeenden")	{
// Schließt das Programm
			System.exit(0);
		}
	}
}