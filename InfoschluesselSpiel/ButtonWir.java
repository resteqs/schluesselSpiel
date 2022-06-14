import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;


public class ButtonWir implements Observable {
	JPanel i;
	String text;
	String name;
	int xKordinate;
	int yKordinate;
	int hoee;
	int breite;
	boolean gedrueckt;
	private List<Observer> observerListe = new ArrayList<Observer>();
	public ButtonWir(JPanel panel, String Name, String Text, int xK, int yK, int ho, int br) {
		i = panel;
		name = Name;
		text = Text;
		xKordinate = xK;
		yKordinate = yK;
		hoee = ho;
		breite = br;
		gedrueckt = false;
		this.neuerKnopf();
	}
	public void neuerKnopf() {
		JButton b1 = new JButton(text);
		b1.setLayout(null);
		i.add(b1);
		b1.setBounds(xKordinate, yKordinate, hoee, breite);
		b1.setVisible(true);
		b1.addActionListener(e -> reacktion());
	}
	public void reacktion() {
		gedrueckt = true;
		this.benachrichtigeObserver();

	}
	public void regrestrireObserver(Observer beobachter) {
		this.observerListe.add(beobachter);
	}
	public void löscheObserver(Observer beobachter) {
		this.observerListe.add(beobachter);
	}
	public void benachrichtigeObserver() {
		for (Observer beobachter : observerListe) {
			beobachter.aktualiesiere(this);
		}
	}
	public boolean enderung() {
		return gedrueckt;
	}
	public String getName() {
		return name;
	}
}
