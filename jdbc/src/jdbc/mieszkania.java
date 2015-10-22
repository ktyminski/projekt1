package jdbc;

public class mieszkania {

	private long idmieszkania;
	private String ulica;
	private long budynek;
	private long mieszkanie;
	private int czynsz;
	private long Wlasciciel_id;
	private long Wynajmujacy_id;
	
	public long getIdmieszkania() {
		return idmieszkania;
	}
	public void setIdmieszkania(long idmieszkania) {
		this.idmieszkania = idmieszkania;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public long getBudynek() {
		return budynek;
	}
	public void setBudynek(long budynek) {
		this.budynek = budynek;
	}
	public long getMieszkanie() {
		return mieszkanie;
	}
	public void setMieszkanie(long mieszkanie) {
		this.mieszkanie = mieszkanie;
	}
	public int getCzynsz() {
		return czynsz;
	}
	public void setCzynsz(int czynsz) {
		this.czynsz = czynsz;
	}
	public long getWlasciciel_id() {
		return Wlasciciel_id;
	}
	public void setWlasciciel_id(long wlasciciel_id) {
		Wlasciciel_id = wlasciciel_id;
	}
	public long getWynajmujacy_id() {
		return Wynajmujacy_id;
	}
	public void setWynajmujacy_id(long wynajmujacy_id) {
		Wynajmujacy_id = wynajmujacy_id;
	}
	
	
}
