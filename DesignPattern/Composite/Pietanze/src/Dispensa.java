import java.util.Map;

public class Dispensa {
	private Dispensa() {} // non istanziabile

	private static Map<String, Integer> tabellaCalorie = Map.of( // max 10
			"pomodoro", 18, 
			"farina", 364, 
			"uova", 155, 
			"cipolla", 40, 
			"macinato", 212, 
			"olio", 884, 
			"burro", 717,
			"panna", 204, 
			"parmigiano", 431, 
			"funghi", 387);

	public static Pietanza getIngrediente(String nome, int quantita) {
		if (tabellaCalorie.containsKey(nome)) {
			return new Ingrediente(nome, quantita, tabellaCalorie.get(nome));
		} else {
			return new Ingrediente(nome, quantita, 0); // es. sale, pepe, acqua
		}
	}

	public static Pietanza getPreparato(String nome) {
		return new Preparato(nome);
	}
}
