public class MainClass {
	
	public static void main(String[] args)
	{
		//Ruft beim Bildschirmfenster auf, dass ein neues Fenster erstellt und geöffnet werden soll
		BildschirmFenster.getInstance().openWindow();

		//TEST: Startet das Spiel, dass die Steuerung des Spielers funktionsfähig wird
		//	Auskommentieren oder wieder löschen, wenn beim Arbeiten stört
		GameManager.getInstance().spielStarten();

		//TEST: Erstellt ein Image fuer den Hintergrund um diesen anzuzeigen
		new Image("bilder/Konzept_dark_background.jpg", 1920, 1080);
	}
}
