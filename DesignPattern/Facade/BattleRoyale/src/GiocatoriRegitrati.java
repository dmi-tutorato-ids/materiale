import java.util.ArrayList;
import java.util.List;

// Componente del sottosistema
public class GiocatoriRegitrati {
	List<Integer> idList = new ArrayList<>();
	
	public boolean isRegistrato(Giocatore g) {
		return idList.contains(g.getID());
	}
	
	public void registra(Giocatore g) {
		if (!idList.contains(g.getID())) 
			idList.add(g.getID());
	}
}
