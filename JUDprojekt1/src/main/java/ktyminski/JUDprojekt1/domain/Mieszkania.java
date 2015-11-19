package ktyminski.JUDprojekt1.domain;

public class Mieszkania {
	private int idMieszkania;
	private int Wlasciciel_id;
	private int Wynajmujacy_id;
	private String ulica;
	private int budynek;
	private int mieszkanie;
	private int czynsz;
	
	public Mieszkania(int idMieszkania, int wlasciciel_id, int wynajmujacy_id, String ulica, int budynek,
			int mieszkanie, int czynsz) {
		super();
		this.idMieszkania = idMieszkania;
		this.Wlasciciel_id = wlasciciel_id;
		this.Wynajmujacy_id = wynajmujacy_id;
		this.ulica = ulica;
		this.budynek = budynek;
		this.mieszkanie = mieszkanie;
		this.czynsz = czynsz;
	}
	
	
	
	
	public Mieszkania() {
		// TODO Auto-generated constructor stub
	}




	public int getIdMieszkania() {
		return idMieszkania;
	}
	public void setIdMieszkania(int idMieszkania) {
		this.idMieszkania = idMieszkania;
	}
	public int getWlasciciel_id() {
		return Wlasciciel_id;
	}
	public void setWlasciciel_id(int wlasciciel_id) {
		Wlasciciel_id = wlasciciel_id;
	}
	public int getWynajmujacy_id() {
		return Wynajmujacy_id;
	}
	public void setWynajmujacy_id(int wynajmujacy_id) {
		Wynajmujacy_id = wynajmujacy_id;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBudynek() {
		return budynek;
	}
	public void setBudynek(int budynek) {
		this.budynek = budynek;
	}
	public int getMieszkanie() {
		return mieszkanie;
	}
	public void setMieszkanie(int mieszkanie) {
		this.mieszkanie = mieszkanie;
	}
	public int getCzynsz() {
		return czynsz;
	}
	public void setCzynsz(int czynsz) {
		this.czynsz = czynsz;
	}
	
	

}
