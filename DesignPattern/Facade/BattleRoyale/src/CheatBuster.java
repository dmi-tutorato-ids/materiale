import java.util.Arrays;
import java.util.List;

// Componente del sottosistema
public class CheatBuster {
	private List<String> blackList = Arrays.asList("spara-coccodrilli", "spara-galline");

	public boolean isCheater(Giocatore g) {
		return blackList.contains(g.getEquip().toLowerCase());
	}
}
