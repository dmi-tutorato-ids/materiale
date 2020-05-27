// Classe di supporto, esterna al sottosistema mascherato dal Facade
public class Giocatore {
	private static final String DEFAULT_EQUIP = "pistola";
	private int id;
	private String equip;
	
	public Giocatore(int id) {
		this.id = id;
		equip = DEFAULT_EQUIP;
	}

	public int getID() {
		return id;
	}
	
	public String getEquip() {
		return equip;
	}
	
	public void setEquip(String equip) {
		this.equip = equip;
	}
	
}
