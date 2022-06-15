public interface Observable {
	
// Jedes Observable muss in der Lage sein Observer zu einer Liste hinzuzufuegen
	public void regrestrireObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein Observer von einer Liste zu loeschen
	public void loescheObserver(Observer beobachter);
	
// Jedes Observable muss in der Lage sein, bie veraenderungen seine Observer zu benachrichtigen
	public void benachrichtigeObserver();
	
// Gibt den namen des Observable zur�ck
	public String getName();
}
