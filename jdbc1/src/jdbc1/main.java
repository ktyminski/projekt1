package jdbc1;

import java.sql.*;

public class main {
	
	static Connection polaczenie;
	static Statement statement;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			polaczenie=DriverManager.getConnection("jdbc:mysql://localhost:3306/wynajem","root","");
			statement=polaczenie.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metody.wyswietl(statement);
		metody.dodaj(polaczenie);
	}
}
