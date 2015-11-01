package jdbc1;

import java.sql.*;
import java.util.Scanner;

public class main {
	
	static Connection polaczenie;
	static Statement statement;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		try {
			polaczenie=DriverManager.getConnection("jdbc:mysql://localhost:3306/wynajem","root","");
			statement=polaczenie.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1 - wyswietla baze , 2 - dodaje rekordy do bazy, 3 - usuwa rekordy z bazy 4 - modyfikacja rekordu");
		int wybor=0;
		wybor=scan.nextInt();
		switch (wybor)
		{
		case 1:
			metody.wyswietl(statement);
			break;
		case 2:
			metody.dodaj(polaczenie);
			break;
		case 3:
			metody.usun(polaczenie);
			break;
		case 4:
			metody.update(polaczenie);
			break;
		}
		
	}
}
