import java.awt.*;
import javax.swing.*;

public class TableWir {

	// erstellt Variablen zum abspeichern vom Panel
	JPanel panel;
	
	// erstellt ein 2D Array (ist nur vorübergehend in zukunft bekommt man ein 2D arry von der Dattenbank)
	String[] [] data = {
			{"Bill", "200"},
			{"Jonas","70"},
			{"Paul","20"},

	};
	
	// Panel wird mitgegeben auf dem die Tabelle erstelt werden soll
	public TableWir(JPanel newPanel) {
		
		// das Panel wird in der Vorgesehenen Variable gespeichert
		panel = newPanel;
		
		// Methode zum erstellen der Tabelle wird aufgerufen
		this.tableErstellen();

	}
	
	// Methode die die Tabelle erstelt
	public void tableErstellen() {
		
		// Eine Start Zahl von welcher aus dann die einzelnen Spalten erstelt werden
		int xKordStart = 60;
		
		// Die Überschrifft Zeilen werden erstelt
		this.jLableEinstellen("Name", 350, 50, 30);
		this.jLableEinstellen("Punkte:", 650, 50, 30);
		
		// For schleife in der je nach anzahl der sich im Array befinden Personen die Zeilen erstelt werden
		for (int i = 0; i < data.length; i++) {
			
			/*
			 	Hier wird eine Spalte erstelt
			 	Mitgabe 1: der Text auß der Spalte in der man sich gerade befindet (einmal in der Zeile 1 und einmal in der Zeile 2)
			 	Mitgabe 2: die X Kordinate
			 	Mitgabe 3: die y Kordinate (der Grundsaetzliche abstand zum Oberen Rand wird addiert mit i+1 (+1 da Arrays immer mit 0 beginnen) mal die höhe eines Feldes.
			 				--> je mehr Felder bereitz exestieren desto groeßer wird die y Kordinate
			 	Mitgabe 4: die Schrifftgöße
			*/
			this.jLableEinstellen(data[i] [0], 350, xKordStart + (i + 1) * 50, 25);
			this.jLableEinstellen(data[i] [1], 650, xKordStart + (i + 1) * 50, 25);
		}
	}
	
	// Methode die für das migegebene jLable einstelt
	private void jLableEinstellen(String text, int xKord, int yKord, int schriftGröße) {
		
		// erstelt das Jlabel mit dem richtigen Text
		JLabel lable = new JLabel(text, SwingConstants.CENTER);
		
		// definiert die gröse und die Kordinaten des jLabel
		lable.setBounds(xKord, yKord, 300, 50);
		
		// definiert die Schrifftgröße
		lable.setFont(new Font("Front", 0, schriftGröße));
		
		// setzt den Hintergrund auf weiß
		lable.setOpaque(true);		
		lable.setBackground(Color.white);
		
		// erstelt einen Ramen in schwarz
		lable.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		// zeigt das JLable an
		lable.setVisible(true);
		
		// JLabel wird dem JPanel hinzugefuegt
		panel.add(lable);
	}
}
