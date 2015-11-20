package ktyminski.JUDprojekt1;

import java.sql.*;
import java.util.ArrayList;

import ktyminski.JUDprojekt1.domain.Mieszkania;
public class MieszkaniaManager {
	
	static Connection polaczenie;
	static Statement statement;
	
		public static void polaczenie(){
			try {
				polaczenie = DriverManager.getConnection("jdbc:mysql://localhost:3306/mieszkania", "root", "admin");
				statement = polaczenie.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){	
			try {
				polaczenie = DriverManager.getConnection("jdbc:mysql://localhost:3306/mieszkania", "root", "admin");
				statement = polaczenie.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return polaczenie;
       }
		
		public static int addmieszkania(Mieszkania mieszkania){	
			int count = 0;
			try {
				PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("INSERT INTO mieszkania (idMieszkania, Wlasciciel_id, Wynajmujacy_id, Ulica, Budynek, Mieszkanie, Czynsz) VALUES (?, ?, ?, ?,?,?,?)");
				addmieszkaniaStmt.setInt(1, mieszkania.getIdMieszkania());
				addmieszkaniaStmt.setInt(2, mieszkania.getWlasciciel_id());
				addmieszkaniaStmt.setInt(3, mieszkania.getWynajmujacy_id());
				addmieszkaniaStmt.setString(4, mieszkania.getUlica());
				addmieszkaniaStmt.setInt(5, mieszkania.getBudynek());
				addmieszkaniaStmt.setInt(6, mieszkania.getMieszkanie());
				addmieszkaniaStmt.setInt(7, mieszkania.getCzynsz());
				count = addmieszkaniaStmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return count;
		
	}

		public static ArrayList<Mieszkania> mieszkaniaWyswietl(){
			ArrayList<Mieszkania> mieszkania = new ArrayList<Mieszkania>();
			Mieszkania m = new Mieszkania();
			
			try {
				ResultSet rs = statement.executeQuery("select * from mieszkania");
			
				while(rs.next()){
					m.setIdMieszkania(rs.getInt("idMieszkania"));
					m.setWlasciciel_id(rs.getInt("Wlasciciel_id"));
					m.setWynajmujacy_id(rs.getInt("Wynajmujacy_id"));
					m.setUlica(rs.getString("Ulica"));
					m.setBudynek(rs.getInt("Budynek"));
					m.setMieszkanie(rs.getInt("Mieszkanie"));
					m.setCzynsz(rs.getInt("Czynsz"));
				}
				mieszkania.add(m);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return mieszkania;
	}

		public static int editmieszkania(Mieszkania mieszkania) {   
			 int count = 0;
						try {
							PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("UPDATE mieszkania SET Wlasciciel_id=?, Wynajmujacy_id=?,ulica=?,budynek=?,mieszkanie=?,Czynsz=? WHERE idMieszkania=?;");
							
							addmieszkaniaStmt.setInt(1, mieszkania.getWlasciciel_id());
							addmieszkaniaStmt.setInt(2, mieszkania.getWynajmujacy_id());
							addmieszkaniaStmt.setString(3, mieszkania.getUlica());
							addmieszkaniaStmt.setInt(4, mieszkania.getBudynek());
							addmieszkaniaStmt.setInt(5, mieszkania.getMieszkanie());
							addmieszkaniaStmt.setInt(6, mieszkania.getCzynsz());
							addmieszkaniaStmt.setInt(7, mieszkania.getIdMieszkania());
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						return count;
					}
				
		public static int delmieszkania(Mieszkania mieszkania){ 
			int count = 0;
			try {
				PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("DELETE FROM mieszkania WHERE idMieszkania=?;");
				addmieszkaniaStmt.setInt(1, mieszkania.getIdMieszkania());
				count = addmieszkaniaStmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
		
		public static void clearmieszkania() { //tested
	        try {
	        	PreparedStatement clearmieszkania = polaczenie.prepareStatement("delete from mieszkania");
	        	clearmieszkania.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		public static int WynajmujacyMieszkanie(Mieszkania mieszkania){
			int count = 0;
			try {
				PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("UPDATE mieszkania SET Wynajmujacy_id=? WHERE idMieszkania=?;");
				addmieszkaniaStmt.setInt(1, mieszkania.getWynajmujacy_id());
				addmieszkaniaStmt.setInt(2, mieszkania.getIdMieszkania());
				count = addmieszkaniaStmt.executeUpdate();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

		public static void WynajmujacyMieszkania(Mieszkania mieszkania){
			try {
				String query = "SELECT * FROM mieszkania WHERE Wynajmujacy_id=?;";
				PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement(query);
				addmieszkaniaStmt.setInt(1, mieszkania.getWlasciciel_id());
				ResultSet rs = addmieszkaniaStmt.executeQuery();
				
				
				while(rs.next()){
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
