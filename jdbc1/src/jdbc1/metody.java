package jdbc1;

import java.sql.*;

public class metody {
	
static PreparedStatement preparedstatement;


	public static void wyswietl(Statement sta)
	{
		ResultSet rs;
		try {
			rs = sta.executeQuery("select * from Mieszkania");
			
			while(rs.next())
			{
				String format = "%-5s%-5s%-5s%-13s%-5s%-5s%-5s";
				System.out.printf(format, rs.getString("idMieszkania"), rs.getString("Wlasciciel_id"), rs.getString("Wynajmujacy_id"), rs.getString("ulica"), rs.getString("budynek"), rs.getString("mieszkanie"), rs.getString("czynsz"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static void dodaj(Connection conn)
	{
		try {
			preparedstatement=conn.prepareStatement("INSERT INTO Mieszkania(idMieszkania,Wlasciciel_id,Wynajmujacy_id,ulica,budynek,mieszkanie,czynsz) VALUES(?,?,?,?,?,?,?)");
			preparedstatement.setString(1,"5" );
			preparedstatement.setString(2,"1" );
			preparedstatement.setString(3,"1" );
			preparedstatement.setString(4,"2" );
			preparedstatement.setString(5,"2" );
			preparedstatement.setString(6,"2" );
			preparedstatement.setString(7,"2" );
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
