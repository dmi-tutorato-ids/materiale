// Operazione.java
// contiene annotazioni per guidare la generazione della javadoc
// usare javadoc *.java per generare la documentazione per tutti  
// i sorgenti (anche per quelli non annotati)
import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta usata per gestire un operazione di calcolo 
 * su di una lista di valori (operandi). La logica dell'operazione 
 * di calcolo viene definita nelle sotto-classi.  
 * 
 * @author Andrea Fornaia
 * 
 */
public abstract class Operazione {
	/**
	 * Lista degli operandi usati per il calcolo del risultato.
	 * 
	 */
	protected List<Float> valori = new ArrayList<>();
	
	public Operazione(String operandi) {
		parsaOperandi(operandi);
	}
	
	/**
	 * Effettua il parsing della lista degli operandi. Il comportamento di
	 * default e' di aggiungere ogni elemento alla lista dei valori. Puo' essere ridefinito.
	 * 
	 * @param operandi stringa contenente la lista di operandi separati da ','.
	 */
	protected void parsaOperandi(String operandi) {
		for (String s: operandi.split(",")) {
			valori.add(Float.parseFloat(s));
		}
	}
	
	/**
	 * Calcola il risultato dell'operazione. Deve usare la lista di valori.
	 * 
	 * @return risultato dell'operazione.
	 */
	public abstract float calcolaRisultato(); 
	
}