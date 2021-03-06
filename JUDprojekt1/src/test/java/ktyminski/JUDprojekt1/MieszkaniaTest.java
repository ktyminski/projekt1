package ktyminski.JUDprojekt1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ktyminski.JUDprojekt1.domain.Mieszkania;
import ktyminski.JUDprojekt1.MieszkaniaManager;


public class MieszkaniaTest {
	
	public Mieszkania getMieszkanie(){
		 Mieszkania mieszkania1 = new Mieszkania();
	        mieszkania1.setIdMieszkania(5);
	        mieszkania1.setWlasciciel_id(2);
	        mieszkania1.setWynajmujacy_id(2);
	        mieszkania1.setUlica("witosa");
	        mieszkania1.setBudynek(54); 
	        mieszkania1.setMieszkanie(57); 
	        mieszkania1.setCzynsz(1200); 
	        
		 return mieszkania1;
	 }
	public Mieszkania getMieszkanienext(){
		 Mieszkania mieszkania1 = new Mieszkania();
	        mieszkania1.setIdMieszkania(2);
	        mieszkania1.setWlasciciel_id(3);
	        mieszkania1.setWynajmujacy_id(2);
	        mieszkania1.setUlica("kapliczna");
	        mieszkania1.setBudynek(36); 
	        mieszkania1.setMieszkanie(54); 
	        mieszkania1.setCzynsz(1278); 
	        
		 return mieszkania1;
	 }
	 

	 @Test
		 public void checkConnection(){
	        assertNotNull(MieszkaniaManager.getConnection());
	 }
	 
	 
	 @Test
	 public void dodawanieTest(){
		 	MieszkaniaManager.getConnection();
	       MieszkaniaManager.wyczyscbazemieszkania();
	        assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
	       assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
	 }
	 
	 @Test
		public void usuwanieTest(){
				MieszkaniaManager.getConnection();
			 	MieszkaniaManager.wyczyscbazemieszkania();
		    	assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
		        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
		        assertEquals(MieszkaniaManager.deletemieszkania(getMieszkanie()) , 1);
		        assertFalse(MieszkaniaManager.mieszkaniaWyswietl().contains(getMieszkanie()));
		}
	 
	 @Test
		public void wyczyscbazeTest(){
			 	MieszkaniaManager.getConnection();
			 	MieszkaniaManager.wyczyscbazemieszkania();
		    	assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
		        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
		    	MieszkaniaManager.wyczyscbazemieszkania();
		    	assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania(), 0);
		}
	 
	 
 
	 @Test
	 public void edytowanieTest(){
		 	MieszkaniaManager.getConnection();
	        MieszkaniaManager.wyczyscbazemieszkania();
	        MieszkaniaManager.addmieszkania(getMieszkanie());
	        
	        Mieszkania nowemieszkania = new Mieszkania();
	        nowemieszkania.setIdMieszkania(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania()); 
	        nowemieszkania.setWlasciciel_id(2);
	        nowemieszkania.setWynajmujacy_id(2);
	        nowemieszkania.setUlica("polna");
	        nowemieszkania.setBudynek(43);
	        nowemieszkania.setMieszkanie(7);
	        nowemieszkania.setCzynsz(1200);
	        
	        
	       assertEquals(MieszkaniaManager.editmieszkania(nowemieszkania),1);

	       assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWlasciciel_id(),2);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWynajmujacy_id(),2);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getUlica(),"polna");
	       assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getBudynek(),43);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getMieszkanie(),7);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getCzynsz(),1200);
	        
	 }
 
   
	       
	
	 @Test
		public void WyswietlanieTest(){
		 		MieszkaniaManager.getConnection();
		 		MieszkaniaManager.wyczyscbazemieszkania();
		 		
		 				 		
		 		MieszkaniaManager.addmieszkania(getMieszkanie());	
		 		MieszkaniaManager.addmieszkania(getMieszkanienext());	
		        
		        ArrayList<Mieszkania> mieszkania = new ArrayList<Mieszkania>();
		        mieszkania = MieszkaniaManager.Wynajmujacymieszkania(getMieszkanie());
		        
		        System.out.println(mieszkania.size());
		        for(int i= 0; i<mieszkania.size(); i++){
		        	
		            assertEquals(mieszkania.get(i).getWlasciciel_id(), 2);
		            }
		        	
		}
	@Test
	public void wynajmujacyMieszkanie(){
			MieszkaniaManager.getConnection();
	        MieszkaniaManager.wyczyscbazemieszkania();
	        MieszkaniaManager.addmieszkania(getMieszkanie());
	        
	        Mieszkania newmieszkania = new Mieszkania();
	        newmieszkania.setIdMieszkania(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania()); 
	        newmieszkania.setWynajmujacy_id(3);
	        
	        assertEquals(MieszkaniaManager.WynajmujacyMieszkanie(newmieszkania), 1);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania(), 5);
	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWynajmujacy_id(), 3);
	        
	}
	//
}


