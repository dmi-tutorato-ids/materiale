import java.util.ArrayList;
import java.util.List;

// Concrete Subject
public class AssistenteVocale extends Subject {
	List<ComandoVocale> storicoComandi = new ArrayList<>(); // stato da monitorare
	
	// cambia lo stato, quindi notifica gli Observer
	public void registra(ComandoVocale cv) { // setState()
		System.out.println("[Comando] " + cv.getTrascrizione());
		storicoComandi.add(cv);
		this.notifyObservers();
	}
	
	ComandoVocale getUltimoComando() { // getState()
		return storicoComandi.get(storicoComandi.size()-1);
	}
}
