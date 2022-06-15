
public interface Observable {
	
// Jedes Observable muss in der Lage sein Observer zu einer Liste hinzuzufügen
	public void regrestrireObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein Observer von einer Liste zu löschen
	public void löscheObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein, bie veränderungen seine Observer zu benachrichtigen
	public void benachrichtigeObserver();
	
// Gibt den namen des Observabele zurück
	public String getName();
}
