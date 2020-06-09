public class Carico implements Stato {

	@Override
	public Stato spara() {
		System.out.println("L'archibugio fa fuoco!");
		return new Scarico();
	}

	@Override
	public Stato ricarica() {
		System.out.println("L'archibugio è già carico");
		return this;
	}

	@Override
	public Stato ripara() {
		System.out.println("L'archibugio funziona già perfetamente");
		return this;
	}
	
}