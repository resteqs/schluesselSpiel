import javax.swing.JPanel;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;


public class ButtonWir implements Observable {
	private JPanel panel;
	private String text;
	private String name;
	private int xKordinate;
	private int yKordinate;
	private int hoehe;
	private int breite;
	
//erzeugt eine Liste zum Speichern von allen Observern
	private List<Observer> observerListe = new ArrayList<Observer>();

	public ButtonWir(JPanel newPanel, String Name, String Text, int xKord, int yKord, int newHoehe, int newBreite) {
		
// Es werden mehrere Mitgabe werte mitgegeben und den jeweiligen Variablen zugeordnet:
// 1. Das Panel, auf welchem der Knopf erstellt werden soll
		panel = newPanel;
		
// 2. Der Name mit welchem der Button sp�ter vom Observer erkannt werden kann
		name = Name;
		
// 3. Der Text der in dem Button stehen soll
		text = Text;
		
// 4. Die xKoordinate des Buttons
		xKordinate = xKord;
		
// 5. Die yKoordinate des Buttons
		yKordinate = yKord;
		
// 6. Die Hoehe des Buttons
		hoehe = newHoehe;
		
// 7. Die Breite des Button
		breite = newBreite;
		
// Funktion wird aufgerufen welche den eigentlichen Button erstellt
		this.neuerKnopf();
	}
	public void neuerKnopf() {

// Neuer Button wird erzeugt
		JButton button = new JButton(text);

// Der Button wird dem Panel zugewiesen
		panel.add(button);

// Kordinaten und groesse des Buttons werden gesetzt
		button.setBounds(xKordinate, yKordinate, hoehe, breite);
		
// zeigt den Button an
		button.setVisible(true);

//gibt dem Button keinen Focus, sodass das Fenster weiterhin auf den Tastaturinput reagiert
		button.setFocusable(false);

// Das ist eine Funktion die sobald sie gedrueckt wird dei Funktion benachrichigeObserver aufruft
		button.addActionListener(e -> benachrichtigeObserver());
	}

// eine Funktion, die eine Klasse, welche das Interfase Observer als Referenz hat, zu der Observerliste hinzuf�gt
	public void regrestrireObserver(Observer beobachter) {
		this.observerListe.add(beobachter);
	}
	
// eine Funktion, die eine Klasse, welche das Interfase Observer als Referenz hat, von der Observerliste loescht
	public void loescheObserver(Observer beobachter) {
		this.observerListe.remove(beobachter);
	}
	
// eine Funktion die bei allen Observern die in der observerListe gespeichert sind die funktion aktulisiere aufruft
	public void benachrichtigeObserver() {
		for (Observer beobachter : observerListe) {
			beobachter.aktualiesiere(this);
		}
	}
	
// eine Funktion die den Namen zurueckgiebt
	public String getName() {
		return name;
	}
}
