package jdbc1;

import java.sql.*;
import java.util.Scanner;

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
		 main.main(null);
	}
	public static void dodaj(Connection conn)
	{
		
				String parametr;
				Scanner scan = new Scanner(System.in);
				
				try {
					preparedstatement=conn.prepareStatement("INSERT INTO Mieszkania(idMieszkania,Wlasciciel_id,Wynajmujacy_id,ulica,budynek,mieszkanie,czynsz) VALUES(?,?,?,?,?,?,?)");
					System.out.println("podaj po enterze ::id mieszkania .id wlasciciela. id wynajmujacego. ulice. budynek. mieszkanie. czynsz");
					parametr=scan.nextLine();
					preparedstatement.setString(1,parametr );
					parametr=scan.nextLine();
					preparedstatement.setString(2,parametr );
					parametr=scan.nextLine();
					preparedstatement.setString(3,parametr );
					parametr=scan.nextLine();
					preparedstatement.setString(4,parametr );
					parametr=scan.nextLine();
					preparedstatement.setString(5,parametr );
					parametr=scan.nextLine();
					preparedstatement.setString(6,parametr);
					parametr=scan.nextLine();
					preparedstatement.setString(7,parametr);
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				 main.main(null);
		
	}
	public static void usun(Connection conn)
	{
	
	int parametr;
	Scanner scan = new Scanner(System.in);
	System.out.println("Podaj klucz glowny");
	try {
		preparedstatement=conn.prepareStatement("DELETE FROM MIESZKANIA WHERE idMieszkania=?");
		
		parametr=scan.nextInt();
		preparedstatement.setInt(1, parametr);
		preparedstatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   
	}
	 main.main(null);
	}
	
	public static void update(Connection conn)
	{
	
	String parametr;
	Scanner scan = new Scanner(System.in);
	
	try {
		preparedstatement=conn.prepareStatement("UPDATE MIESZKANIA SET Wlasciciel_id=?, Wynajmujacy_id=?, ulica=?, budynek=?, mieszkanie=?, czynsz=? WHERE idMieszkania =?");
		System.out.println("podaj po enterze ::id wlasciciela. id wynajmujacego. ulice. budynek. mieszkanie. czynsz . IDMIESZKANIA");
		
		parametr=scan.nextLine();
		preparedstatement.setString(1,parametr );
		parametr=scan.nextLine();
		preparedstatement.setString(2,parametr );
		parametr=scan.nextLine();
		preparedstatement.setString(3,parametr );
		parametr=scan.nextLine();
		preparedstatement.setString(4,parametr );
		parametr=scan.nextLine();
		preparedstatement.setString(5,parametr );
		parametr=scan.nextLine();
		preparedstatement.setString(6,parametr);
		parametr=scan.nextLine();
		preparedstatement.setString(7,parametr);
		preparedstatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   
	}
	 main.main(null);
	}
}
