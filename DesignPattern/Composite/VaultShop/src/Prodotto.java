public abstract class Prodotto {
	String nome;

	protected Prodotto(String nome) {
		this.nome = nome;
	}

	public Prodotto add(Prodotto p) {
		return this;
	}

	public Prodotto remove(String pNome) {
		return this;
	}

	public String getNome() {
		return nome;
	}

	public abstract int getValore();

	public void show() { 
		show(""); 
	}
	
	protected abstract void show(String tabs);
}