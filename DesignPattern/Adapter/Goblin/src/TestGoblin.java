public class TestGoblin {
	public static void main(String[] args) {
		testObjectAdapter();
		testClassAdapter();
	}

	private static void testObjectAdapter() {
		System.out.println("\n# Test Object Adapter");
		Goblin gb = new GoblinOA();
		testGoblin(gb);
	}

	private static void testClassAdapter() {
		System.out.println("\n# Test Class Adapter: metodi Target");
		Goblin gb = new GoblinCA();
		testGoblin(gb);

		System.out.println("\n# Test Class Adapter: metodi Adaptee");
		PelleVerde pv = new GoblinCA();
		testPelleVerde(pv);
	}

	private static void testGoblin(Goblin gb) {
		gb.tiraFreccia(-5.5f);
		gb.tiraFreccia(5.5f);
		gb.tiraFreccia(15.5f);
	}

	public static void testPelleVerde(PelleVerde pv) {
		pv.scagliaPezzoDiLegno(-55);
		pv.scagliaPezzoDiLegno(55);
		pv.scagliaPezzoDiLegno(155);
	}

}
