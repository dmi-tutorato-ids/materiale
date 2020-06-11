public class Client {
	public static void main(String[] args) {
		Prodotto p1 = VaultShop.getBuggyAutonoma();
		Prodotto p2 = VaultShop.getBuggyScontata();

		p1.show();
		System.out.println("Valore Totale: " + p1.getValore());
		
		System.out.println();

		p2.show();
		System.out.println("Valore Totale: " + p2.getValore());
	}
	
}