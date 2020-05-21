public class Armeria {
	private Armeria(){}

	public static Arma getFucilePesante() {
		return new Fucile(new MunizioniPesanti());
	}

	public static Arma getPistolaOrdinanza() {
		return new Pistola(new MunizioniLeggere());
	}
}