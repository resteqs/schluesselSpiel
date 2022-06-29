import javax.swing.JPanel;

public class HighScoreMenu extends MenuWir {
// Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
    private static HighScoreMenu singleton = new HighScoreMenu();
 // Speichert das Panel, das in diesem Menu bearbeitet wird
    private JPanel panel;

	private HighScoreMenu() {
		super(); 
	}

// Gibt das Singleton zur�ck, damit andere Klassen Methoden davon aufrufen k�nnen
    public static HighScoreMenu getInstance() {
        return singleton;
    }
    
// Methode, die ein Panel erstellt
	public void menuAnzeigen() {
// Erstellt das Pannel
		panel = new JPanel();
		panel.setLayout(null);
// F�gt die Buttons hinzu
		this.buttonsErstellen();
		
		this.bestenlisteEinstellen();
// Ver�ndert das Hintergrundbild
		this.hintergrundEinstellen();
// Ruft die Methode auf, die dann das Panel auf dem Bildschirmfenster anzeigen l�sst
		BildschirmFenster.getInstance().addToMenu(panel);
	}

	private void bestenlisteEinstellen() {
		new TableWir(panel);
	}
// Methode, die das Hintergrundbild ver�ndert
	protected void hintergrundEinstellen() {
		ImageWir hintergrund = new ImageWir("bilder/Highscoreliste.jpg", Konstanten.SCREEN_WIDTH, Konstanten.SCREEN_HEIGHT, 0, 0);
		panel.add(hintergrund.getjLabel());
	}	
	
// Methode, die die Buttons erstellt
	protected void buttonsErstellen() {
// Erstellt Button "Zur�ck zum Hauptmenu"
		ButtonWir buttonBackToMainMenu = new ButtonWir(panel, "backToMainMenu", "<-- Zur�ck zum Hauptmen�", 75, 500, 200, 100);
// Registriert sich seblst als Observer f�r den Button "Zur�ck zum Hauptmen�"
		buttonBackToMainMenu.regrestrireObserver(this);
	}	
	
// Methode wird aufgerufen, wenn einer der Buttons seinen Zustand �ndert
	public void aktualiesiere(Observable veraendert) {
// �berpr�ft welcher Button gedr�ckt wurde:

		if (veraendert.getName() == "backToMainMenu") {
// �ffnet das Hauptmen�
			MainMenu.getInstance().menuAnzeigen();
		}
	}
}
