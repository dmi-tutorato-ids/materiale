public class Archibugio {
	private Stato stato;

	public Archibugio() {
		stato = new Carico();
	}

	public void spara() {
		stato = stato.spara();
	}

	public void ricarica() {
		stato = stato.ricarica();
	}

	public void ripara() {
		stato = stato.ripara();
	}
}
