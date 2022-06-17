
public abstract class MenuWir implements Observer {

// Ver�ndert den Hintergrund des Men�s
	protected abstract void hintergrundEinstellen();
	
// Erstellt die Buttons, die f�r das jeweilige Men� relevant sind
	protected abstract void buttonsErstellen();
	
// Methode, die zum Anzeigen des jeweiligen Men�s f�hrt.
	public abstract void menuAnzeigen();
	

}
