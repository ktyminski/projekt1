package ktyminski.JUDprojekt1;

import static org.junit.Assert.*;


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
	 

		 @Test
		 public void checkConnection(){
	        assertNotNull(MieszkaniaManager.getConnection());
	 }
	 
	 
	 @Test
	 public void addTest(){
		 	MieszkaniaManager.polaczenie();
	       MieszkaniaManager.clearmieszkania();
	        assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
	       assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
	 }
 
//	 @Test
//	 public void editTest(){
//		 	MieszkaniaManager.polaczenie();
//	        MieszkaniaManager.clearmieszkania();
//	        MieszkaniaManager.addmieszkania(getMieszkanie());
//	        
//	        Mieszkania nowamieszkania = new Mieszkania();
//	        nowamieszkania.setIdMieszkania(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania()); 
//	        nowamieszkania.setWlasciciel_id(2);
//	        nowamieszkania.setWynajmujacy_id(2);
//	        nowamieszkania.setUlica("polna");
//	        nowamieszkania.setBudynek(43);
//	        nowamieszkania.setMieszkanie(7);
//	        nowamieszkania.setCzynsz(1200);
//	        
//	        
//	        assertEquals(MieszkaniaManager.editmieszkania(nowamieszkania), 1);
//
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWlasciciel_id(), 2);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWynajmujacy_id(), 2);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getUlica(), "polna");
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getBudynek(), 43);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getMieszkanie(), 7);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getCzynsz(),1200);
//	        
//	 }
//	 
//	@Test
//	public void clearTest(){
//		 	MieszkaniaManager.polaczenie();
//		 	MieszkaniaManager.clearmieszkania();
//	    	assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
//	    	MieszkaniaManager.clearmieszkania();
//	    	
//	    	assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania(), null);
//	}
//	       
//	@Test
//	public void deleteTest(){
//			MieszkaniaManager.polaczenie();
//		 	MieszkaniaManager.clearmieszkania();
//	    	assertEquals(MieszkaniaManager.addmieszkania(getMieszkanie()), 1);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().size(), 1);
//	        assertEquals(MieszkaniaManager.delmieszkania(getMieszkanie()) , 1);
//	        assertFalse(MieszkaniaManager.mieszkaniaWyswietl().contains(getMieszkanie()));
//	}
//	
//	@Test
//	public void recHasPackTest(){
//			MieszkaniaManager.polaczenie();
//	        MieszkaniaManager.clearmieszkania();
//	        MieszkaniaManager.addmieszkania(getMieszkanie());
//	        
//	        Mieszkania nowamieszkania = new Mieszkania();
//	        nowamieszkania.setIdMieszkania(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania()); 
//	        nowamieszkania.setWynajmujacy_id(2);
//	        
//	        assertEquals(MieszkaniaManager.WynajmujacyMieszkanie(nowamieszkania), 1);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getIdMieszkania(), 100);
//	        assertEquals(MieszkaniaManager.mieszkaniaWyswietl().get(0).getWynajmujacy_id(), 2);
//	        
//	}
}


