public class TestPartita {
	public static void main(String[] args) {
		System.out.println("# Avvio partita nel Bosco con 10 attacchi");
		new Partita(new Bosco(), 10).gioca();

		System.out.println("\n# Avvio partita nel Vulcano con 10 attacchi");
		new Partita(new Vulcano(), 10).gioca();
	}
}