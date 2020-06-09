import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Preparato extends Pietanza {
	private List<Pietanza> pList = new ArrayList<>();

	public Preparato(String nome) {
		this.nome = nome;
	}

	@Override
	public Preparato add(Pietanza p) {
		Optional<Pietanza> op = pList.stream()
			.filter(x -> x.getNome()
			.equals(p.getNome()))
			.findAny();

		if (op.isEmpty())
			pList.add(p);
		return this;
	}

	@Override
	public Preparato remove(Pietanza p) {
		if (pList.contains(p)) {
			pList.remove(p);
		}
		return this;
	}

	@Override
	public void mostra(String indenta) {
		System.out.println(indenta + "# " + nome);
		pList.forEach(p -> p.mostra(indenta + "\t"));
	}

	@Override
	public int calcolaCalorie() {
		return pList.stream()
			.mapToInt(Pietanza::calcolaCalorie)
			.sum();
	}
}
