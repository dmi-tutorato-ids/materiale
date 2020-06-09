public class Scarico implements Stato {

	@Override
	public Stato spara() {
		System.out.println("L'archibugio si è inceppato!");
		return new Inceppato();
	}

	@Override
	public Stato ricarica() {
		System.out.println("L'archibugio è ora carico");
		return new Carico();
	}

	@Override
	public Stato ripara() {
		System.out.println("L'archibugio funziona già perfetamente");
		return this;
	}

}
