import java.awt.*;
import javax.swing.*;

public class TableWir {

	// erstellt Variablen zum abstpeihern vom Panel
	JPanel panel;
	
	// erstellt ein 2D Arry (ist nur vorübergehend in zukunft bekommt man ein 2D arry von der Dattenbank)
	String[] [] data = {
			{"bill", "2"},
			{"David","100"},
			{"hehe","20"},

	};
	
	// Panel wird mitgegeben auf dem die Tabelle erstellt werden soll
	public TableWir(JPanel newPanel) {
		
		// das Panel wird in der Vorgesehenen Variable gespeichert
		panel = newPanel;
		
		// Methode zum erstellen der Tabelle wird auferufen
		this.tableErstellen();

	}
	
	// Methode die die Tabelle erstellt
	public void tableErstellen() {
		
		// Eine Start Zahl von welcher aus dann die einzelnen Spalten erstellt werden
		int xKordStart = 60;
		
		// Die Überschrifft Zeilen werden erstellt
		this.jLableEinstellen("Name", 350, 50, 30);
		this.jLableEinstellen("Punkte:", 650, 50, 30);
		
		// For schleife in der ja nach anzahl der sich im Array befinden Personen die Restlichen Zeilen erstellt
		for (int i = 0; i < data.length; i++) {
			
			// erstellt die erste Spalte 
			this.jLableEinstellen(data[i] [0], 350, xKordStart + (i + 1) * 50, 25);
			
			// erstellt die zweite Spalte
			this.jLableEinstellen(data[i] [1], 650, xKordStart + (i + 1) * 50, 25);

		}
	}
	
	// Methode die die standart Einstellungen für die einzelnen Felder volzieht
	private void jLableEinstellen(String text, int xKord, int yKord, int schriftGröße) {
		
		// erstellt das Jlabel mit dem richtigen Text
		JLabel lable = new JLabel(text, SwingConstants.CENTER);
		
		// definiert die gröse und die Kordinaten des JLabel
		lable.setBounds(xKord, yKord, 300, 50);
		
		// definiert die Schrifftgröße
		lable.setFont(new Font("Front", 0, schriftGröße));
		
		// setzt den Hintergrund auf weiß
		lable.setOpaque(true);		
		lable.setBackground(Color.white);
		
		// Macht den Rand schwarz
		lable.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		// zeigt das JLable an
		lable.setVisible(true);
		
		// JLabel wird dem JPanel hinzugefuegt
		panel.add(lable);
	}
}
