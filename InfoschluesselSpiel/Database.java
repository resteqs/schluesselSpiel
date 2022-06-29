import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
//nÃ¶tige Erweiterungen um auf Datenbank zuzugreifen

public class Database
{	
	Connection con;
	String [] spieler;
	int [] highscores;
	public Database()
	{
		
	}
	
	public void connect() throws ClassNotFoundException //Verbindung zur Datenbank wird hergestellt
	{
		
		//Zugangsdaten werden vorher festgelegt, um sie leichter Ändern zu können.
		String url = "jdbc:mysql5046.site4now.net/db_a88aa4_hiscore";
		String user = "a88aa4_hiscore";
		String password = "Highscore1!";
		
		try 
		{	
			//Verbindung wird versucht herzustellen, "try{}" verhindert eine Fehlermeldung bei fehlender Verbindung
			con = DriverManager.getConnection(url, user, password);
		}
		catch (SQLException e) //Überprüfung auf Fehler
		{
			System.out.println(e);
		}
	}
	
	public void scoreSpeichern(String spieler, int Score)
	{
		try
		{	//Erstellt einen String mit dem "INSERT" einen neuen Datensatz mit den Werten für Spielername und Score in die Datenbank ein
			String insertSQLcode = "INSERT INTO db_a88aa4_hiscore.highscores(`ID`, `score`, `player`) VALUES (NULL, spieler, score)";
			Statement stmt = con.createStatement();
			stmt.execute(insertSQLcode);
		}
		catch (SQLException e) //Überprüfung auf Fehler
		{
			System.out.println(e);
		}	
	}
	
	public void highscoresAuslesen()
	{
		try
		{	//erstellt eine Abfrage und sendet diese an den Server
			String query = "SELECT `player`,`score` FROM db_a88aa4_hiscore.highscores ORDER BY `score` DESC 10";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			for(int i = 0; i < 10; i++)
			{
				rs.next();
				spieler[i] = rs.getString(1);
				highscores[i] = rs.getInt(2);
			}
		}
		catch (SQLException e)//Überprüfung auf Fehler
		{
			System.out.println(e);
		}
	}
}