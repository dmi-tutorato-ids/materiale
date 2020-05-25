// ha il ruolo di ConcreteProduct
public class Drago implements Nemico {
	int corazza = 10;
	boolean sconfitto = false;

	@Override
	public String getNome() {
		return "Drago";
	}

	@Override
	public void applicaDanno(int danno) {
		if (danno >= corazza)
			sconfitto = true;
	}

	@Override
	public boolean isSconfitto() {
		return sconfitto;
	}
	
}