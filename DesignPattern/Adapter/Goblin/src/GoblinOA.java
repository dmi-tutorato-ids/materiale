// Adapter: variante Object Adapter
public class GoblinOA implements Goblin {
	PelleVerde pv;

	@Override
	public void tiraFreccia(float danno) {
		// validazione dell'input
		if (danno < 0 || danno > 10) {
			System.out.println(String.format("- Danno %.1f fuori range," 
				+ " deve essere compreso tra [0.0..10.0]", danno));
			return;
		}

		// Lazy initialization
		if (pv == null) pv = new PelleVerde();

		// il danno deve essere adattato da [0..10] a [0..100]
		int adaptDanno = Math.round(danno * 10);

		pv.scagliaPezzoDiLegno(adaptDanno);
	}
	
}