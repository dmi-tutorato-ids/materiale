// Adapter: variante Class Adapter
public class GoblinCA extends PelleVerde implements Goblin {
	@Override
	public void tiraFreccia(float danno) {
		// validazione dell'input
		if (danno < 0 || danno > 10) {
			System.out.println(String.format("- Danno %.1f fuori range," 
				+ " deve essere compreso tra [0.0..10.0]", danno));
			return;
		}

		// il danno deve essere adattato da [0..10] a [0..100]
		int adaptDanno = Math.round(danno * 10);

		this.scagliaPezzoDiLegno(adaptDanno);
	}
	
	@Override
	public void scagliaPezzoDiLegno(int danno) {
		// posso aggiungere la validazione dell'input (non presente nell'Adaptee)
		if (danno < 0 || danno > 100) {
			System.out.println(String.format("- Danno %d fuori range," 
				+ " deve essere compreso tra [0..100]", danno));
			return;
		}

		super.scagliaPezzoDiLegno(danno);
	}
}