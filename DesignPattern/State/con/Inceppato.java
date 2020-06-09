public class Inceppato implements Stato {

	@Override
	public Stato spara() {
		System.out.println("L'archibugio è inceppato!");
		return this;
	}

	@Override
	public Stato ricarica() {
		System.out.println("L'archibugio è inceppato!");
		return this;
	}

	@Override
	public Stato ripara() {
		System.out.println("L'archibugio è stato riparato");
		return new Scarico();
	}

}
