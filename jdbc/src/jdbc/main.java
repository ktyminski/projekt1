package jdbc;

import java.sql.*;

public class main {

	static Connection polaczenie;
	static Statement statement = null;
	static ResultSet rs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  
	     
	  try {
		polaczenie = DriverManager.getConnection("jdbc:hsqldb:bazadanych/bazadanych", "admin", "admin");
		statement=polaczenie.createStatement();
		rs = statement.executeQuery("select * from Mieszkania");
		while (rs.next())
		{
			System.out.println(rs.getString("idMieszkania"));
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
