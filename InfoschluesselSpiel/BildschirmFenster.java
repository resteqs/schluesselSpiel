import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BildschirmFenster {
	//Singleton-Pattern stellt sicher, dass es nur ein Objekt der Klasse BildschirmFenster gibt
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
		//Setzt den Titel, der über dem Fenster steht auf "Keymaster"
		window.setTitle("Keymaster");
		//Setzt das Icon in der Taskleiste und im Fenster
		ImageIcon img = new ImageIcon("bilder/key.png");
		window.setIconImage(img.getImage());
		//Legt fest, dass das Programm aufhört, wenn das Fenster geschlossen wird
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Legt die größe fest 
		window.setSize(Konstanten.SCREEN_WIDTH,Konstanten.SCREEN_HEIGHT); //To do: richtige Fenstergröße eingeben
		//Legt fest, dass die Fenstergröße nicht verändert werden kann
		window.setResizable(false);
		//Zeigt das Fenster an
		window.setVisible(true);
		//Fügr den KeyListener hinzu, dass das Fenster auf Tastatureingaben reagiert
		window.addKeyListener(Tastaturinput.getInstance());
	}
	public void addToMenu(JPanel jPanel)
	{
		//Falls bereits die Grafikelemente von einem anderen Menu existieren werden diese aus dem Fenster entfernt
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

	/**
	 * Löscht das aktuelle Menü aus dem Fenster
	 */
	public void removeMenu() {
		if(menuPanel != null) {
			window.remove(menuPanel);
		}
	}

	/**
	 * Gibt das Spielfenster zurück
	 * @return
	 */
	public JFrame getWindow() {
		return window;
	}
}
