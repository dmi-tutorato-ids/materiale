// ha il ruolo di ConcreteProduct
public class Goblin implements Nemico {
	int puntiFerita = 5;

	@Override
	public String getNome() {
		return "Goblin";
	}

	@Override
	public void applicaDanno(int danno) {
		puntiFerita -= (danno * 2);
	}

	@Override
	public boolean isSconfitto() {
		return (puntiFerita <= 0);
	}
	
}