import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BildschirmFenster {
	//Singelton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
	private static BildschirmFenster singleton = new BildschirmFenster();
	//Speichert eine Referenz zum geöffneten Fenster
	private JFrame window;
	//Speichert alle Grafikelemente die mit den jeweiligen Menüs zusammenhängen
	private JPanel menuPanel;
	
	private BildschirmFenster()
	{}
	public static BildschirmFenster getInstance()
	{
		return singleton;
	}
	
	//Öffnet ein neues Fenster
	public void openWindow()
	{
		//Erstellt das Fenster
		window = new JFrame();
		//Setzt den Titel der über dem Fenster steht auf "Keymaster"
		window.setTitle("Keymaster");
		//Legt fest, dass das Programm aufhört wenn das Fenster geschlossen wird
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Legt die größe fest 
		window.setSize(700,700); //To do: richtige Fenstergröße eingeben
		//Legt fest, dass die Fenstergröße nicht verändert werden kann
		window.setResizable(false);
		//Zeigt das Fenster an
		window.setVisible(true);
	}
	public void addToMenu(JPanel jPanel)
	{
		//Falls berreits die Grafikelemente von einem anderen Menu existieren werden diese aus dem Fenster entfernt
		if (menuPanel != null)
		{
			window.remove(menuPanel);
		}
		//Die neuen Grafikelemente werden gespeichert
		menuPanel = jPanel;
		//Die neuen Grafikelemente werden dem Fenster hinzugefügt
		window.add(menuPanel, BorderLayout.CENTER);
		//Das Fenster zeigt alle hinzugefügte Elemente an
		window.setVisible(true);
	}
}
