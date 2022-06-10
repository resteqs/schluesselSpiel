//sollte fertig sein, Datenbank dazu existiert jedoch noch nicht. Muss also noch auf die Datenbank angepasst werden
import java.sql.*; 
//nötige Erweiterungen um auf Datenbank zuzugreifen

public class Database
{
	{}
	
	public int insertData(String spieler, int punkte)
	{
		Connection con = null;
		/* try, damit, wenn ein Fehler auftritt nicht der Computer abstürzt. Da hier auf einen externen Server zugegriffen wird kann das 
		*  jedoch gut mal sein 
		*/ 
		try {
			con = DriverManager.getConnection("database", "user", "password");
			Statement stmt = con.createStatement();
		String sql = "insert into Tabelle1 (Spieler, Punkte) values(spieler , punkte)";
		return stmt.executeUpdate("INSERT INTO `Highscores` (`ID`, `Spieler`, `Punktezahl`) VALUES (NULL, "+ spieler +", "+ punkte+ ");");
		}
	catch (SQLException e) {return 0;}
		
	}
}