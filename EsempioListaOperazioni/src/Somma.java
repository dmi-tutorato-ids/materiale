// Somma.java
public class Somma extends Operazione {

	public Somma(String operandi) {
		super(operandi);
	}

	/**
	 * Calcola il risultato dell'operazione Somma.
	 * 
	 * @return risultato dell'operazione.
	 */
	@Override
	public float calcolaRisultato() {
		float result = 0;
		
		for (float f : valori) {
			result += f;
		}
		return result;
	}
}