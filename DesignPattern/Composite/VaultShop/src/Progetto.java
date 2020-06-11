import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Progetto extends Prodotto {
	List<Prodotto> pList = new ArrayList<>();

	public Progetto(String nome) {
		super(nome);
	}

	@Override
	public Prodotto add(Prodotto p) {
		if (! pList.contains(p))
			pList.add(p);
		return this;
	}

	@Override 
	public Prodotto remove(String pNome) {
		pList = pList.stream()
			.filter(p -> !p.getNome().equals(pNome))
			.collect(Collectors.toList());
		return this;
	}

	@Override
	public int getValore() {
		return pList.stream()
			.mapToInt(Prodotto::getValore)
			.sum();
	}

	@Override
	protected void show(String tabs) {
		System.out.println(tabs + "Progetto: " + nome);
		pList.stream()
			.forEach(p -> p.show(tabs + "\t"));
	}
	
}