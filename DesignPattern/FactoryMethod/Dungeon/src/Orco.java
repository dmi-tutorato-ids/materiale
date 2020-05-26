// ha il ruolo di ConcreteProduct
public class Orco implements Nemico {
	private int puntiFerita = 10;

	@Override
	public String getNome() {
		return "Orco";
	}

	@Override
	public void applicaDanno(int danno) {
		puntiFerita -= danno;
	}

	@Override
	public boolean isSconfitto() {
		return (puntiFerita <= 0);
	}
	
}