
public interface Observable {
	
// Jedes Observable muss in der Lage sein Observer zu einer Liste hinzuzuf�gen
	public void regrestrireObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein Observer von einer Liste zu l�schen
	public void l�scheObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein, bie ver�nderungen seine Observer zu benachrichtigen
	public void benachrichtigeObserver();
	
// Gibt den namen des Observabele zur�ck
	public String getName();
}
