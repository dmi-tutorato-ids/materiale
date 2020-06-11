public class Elemento extends Prodotto {
	int valore;

	public Elemento(String nome, int valore) {
		super(nome);
		this.valore = valore;
	}

	@Override
	public int getValore() {
		return valore;
	}

	@Override
	protected void show(String tabs) {
		System.out.println(String.format("%s- %s: vale %d tappi", tabs, nome, valore));
	}
	
	
}