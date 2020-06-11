public class VaultShop {

	private VaultShop() {} // non istanziabile

	public static Prodotto getCopertoni() {
		return new Elemento("copertoni", 30);
	}

	public static Prodotto getPartiElettriche() {
		return new Elemento("parti elettriche", 50);
	}

	public static Prodotto getFerriVecchi() {
		return new Elemento("ferri vecchi", 20);
	}

	public static Prodotto getBuggy() {
		return new Progetto("buggy")
			.add(getCopertoni())
			.add(getFerriVecchi());
	}

	public static Prodotto getBuggyAutonoma() {
		return new Progetto("buggy autonoma")
			.add(getBuggy())
			.add(getPartiElettriche());
	}

	public static Prodotto getBuggyScontata() {
		return new Progetto("buggy scontata")
			.add(getBuggy().remove("copertoni"));
	}
	
}