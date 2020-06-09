public class Archibugio {
	public enum Stato {CARICO, SCARICO, INCEPPATO}
	
	private Stato stato;

	public Archibugio() {
		stato = Stato.CARICO;
	}

	public void spara() {
		switch (stato) {
			case CARICO:
				System.out.println("L'archibugio fa fuoco!");
				stato = Stato.SCARICO;
				break;
			case SCARICO:
				System.out.println("L'archibugio si è inceppato!");
				stato = Stato.INCEPPATO;
				break;
			case INCEPPATO:
				System.out.println("L'archibugio è inceppato!");
				break;
			default:
				break;
		}
	}

	public void ricarica() {
		switch (stato) {
			case CARICO:
				System.out.println("L'archibugio è già carico");
				break;
			case SCARICO:
				System.out.println("L'archibugio è ora carico");
				stato = Stato.CARICO;
				break;
			case INCEPPATO:
				System.out.println("L'archibugio è inceppato!");
				break;
			default:
				break;
		}
	}

	public void ripara() {
		switch (stato) {
			case INCEPPATO:
				System.out.println("L'archibugio è stato riparato");
				stato = Stato.SCARICO;
				break;
			default:
				System.out.println("L'archibugio funziona già perfetamente");
				break;
		}
	}
}
