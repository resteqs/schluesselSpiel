
public interface Observer {
	
// Jeder Observer muss in der Lage sein wenn er die Nachricht bekommt das sich etwas bei einen Observable ge�ndert hat die neuen Informationen abzufragen
	public void aktualiesiere(Observable veraendert);
}
