public class MainClass {
	
	public static void main(String[] args)
	{
		//Ruft beim Bildschirmfenster auf, dass ein neues Fenster erstellt und geöffnet werden soll
		BildschirmFenster.getInstance().openWindow();

		//TEST: Startet das Spiel, dass die Steuerung des Spielers, die Einbindung von Hintergrund und Spielergrafik
		// und die Zeitanzeige funktionsfähig wird
		GameManager.getInstance().spielStarten();
	}
}
