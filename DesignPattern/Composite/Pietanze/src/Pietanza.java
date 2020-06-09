public abstract class Pietanza {
	protected String nome;

	public void mostra() {
		mostra("");
	}

	public abstract void mostra(String indenta);

	public abstract int calcolaCalorie();

	/**
	 * add() e remove() non andrebbero chiamate su Leaf.
	 * Si è deciso di metterle qui invece che in Component
	 * per avere trasparenza lato client, a discapito della
	 * sicurezza (il client potrebbe voler aggiungere ingredienti
	 * ad un ingrediente, il che però non avrebbe alcun effetto)
	 */
	public Pietanza add(Pietanza p) {
		return this; // fluent
	}

	public Pietanza remove(Pietanza p) {
		return this; // fluent
	}

	public String getNome() {
		return nome;
	}

	public Pietanza setNome(String nome) {
		this.nome = nome;
		return this; // fluent
	}
}
