
public abstract class MenuWir implements Observer {

// Verändert den Hintergrund des Menüs
	protected abstract void hintergrundEinstellen();
	
// Erstellt die Buttons, die für das jeweilige Menü relevant sind
	protected abstract void buttonsErstellen();
	
// Methode, die zum Anzeigen des jeweiligen Menüs führt.
	public abstract void menuAnzeigen();
	

}
