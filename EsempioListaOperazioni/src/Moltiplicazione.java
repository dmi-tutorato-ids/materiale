// Moltiplicazione.java
public class Moltiplicazione extends Operazione {

	public Moltiplicazione(String operandi) {
		super(operandi);
	}

	/**
	 * Calcola il risultato dell'operazione Moltiplicazione.
	 * 
	 * @return risultato dell'operazione.
	 */
	@Override
	public float calcolaRisultato() {
		float result = 1;
		
		for (float f : valori) {
			result *= f;
		}
		
		return result;
	}
}