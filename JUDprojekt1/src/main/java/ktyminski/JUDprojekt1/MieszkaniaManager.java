package ktyminski.JUDprojekt1;

import java.sql.*;
import java.util.ArrayList;

import ktyminski.JUDprojekt1.domain.Mieszkania;
public class MieszkaniaManager {
	
	static Connection polaczenie;
	static Statement statement;
	
		
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
			Mieszkania mieszk = new Mieszkania();
			
			try {
				ResultSet rs = statement.executeQuery("select * from mieszkania");
			
				while(rs.next()){
					mieszk.setIdMieszkania(rs.getInt("idMieszkania"));
					mieszk.setWlasciciel_id(rs.getInt("Wlasciciel_id"));
					mieszk.setWynajmujacy_id(rs.getInt("Wynajmujacy_id"));
					mieszk.setUlica(rs.getString("Ulica"));
					mieszk.setBudynek(rs.getInt("Budynek"));
					mieszk.setMieszkanie(rs.getInt("Mieszkanie"));
					mieszk.setCzynsz(rs.getInt("Czynsz"));
				}
				mieszkania.add(mieszk);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return mieszkania;
	}
		
		public static int deletemieszkania(Mieszkania mieszkania){ 
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
		
		public static void wyczyscbazemieszkania() { 
	        try {
	        	PreparedStatement clearmieszkania = polaczenie.prepareStatement("delete from mieszkania");
	        	clearmieszkania.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		public static int editmieszkania(Mieszkania mieszkania) {   
			 int count = 0;
						try {
							PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("UPDATE mieszkania SET Wlasciciel_id=?, Wynajmujacy_id=?, ulica=?, budynek=?, mieszkanie=?, Czynsz=? WHERE idMieszkania=?;");
							
							addmieszkaniaStmt.setInt(1, mieszkania.getWlasciciel_id());
							addmieszkaniaStmt.setInt(2, mieszkania.getWynajmujacy_id());
							addmieszkaniaStmt.setString(3, mieszkania.getUlica());
							addmieszkaniaStmt.setInt(4, mieszkania.getBudynek());
							addmieszkaniaStmt.setInt(5, mieszkania.getMieszkanie());
							addmieszkaniaStmt.setInt(6, mieszkania.getCzynsz());
							addmieszkaniaStmt.setInt(7, mieszkania.getIdMieszkania());
							count = addmieszkaniaStmt.executeUpdate();
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						return count;
					}
				
		
		
		

		public static int WynajmujacyMieszkanie(Mieszkania mieszkania){
			int count = 0;
			try {
				
			
				PreparedStatement addmieszkaniaStmt2 = polaczenie.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
				PreparedStatement addmieszkaniaStmt = polaczenie.prepareStatement("UPDATE mieszkania SET Wynajmujacy_id=? WHERE idMieszkania=?;");
				addmieszkaniaStmt.setInt(1, mieszkania.getWynajmujacy_id());
				addmieszkaniaStmt.setInt(2, mieszkania.getIdMieszkania());
				addmieszkaniaStmt2.executeUpdate();
				count = addmieszkaniaStmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
		
		public static ArrayList<Mieszkania> Wynajmujacymieszkania(Mieszkania mieszk){
			ArrayList<Mieszkania> drugiemieszkania = new ArrayList<Mieszkania>();
			Mieszkania mieszk1;
			mieszk1 = new Mieszkania();
			try {
				String query = "SELECT * FROM Mieszkania WHERE Wlasciciel_id=?;";
				
				PreparedStatement addMieszkaniaStmt = polaczenie.prepareStatement(query);
				addMieszkaniaStmt.setInt(1, mieszk.getWlasciciel_id());
				ResultSet rs = addMieszkaniaStmt.executeQuery();
				while(rs.next()){
					
					mieszk1.setIdMieszkania(rs.getInt("idMieszkania"));
					mieszk1.setWlasciciel_id(rs.getInt("Wlasciciel_id"));
					mieszk1.setWynajmujacy_id(rs.getInt("Wynajmujacy_id"));
					mieszk1.setUlica(rs.getString("Ulica"));
					mieszk1.setBudynek(rs.getInt("Budynek"));
					mieszk1.setMieszkanie(rs.getInt("Mieszkanie"));
					mieszk1.setCzynsz(rs.getInt("Czynsz"));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return drugiemieszkania;
		}



}
