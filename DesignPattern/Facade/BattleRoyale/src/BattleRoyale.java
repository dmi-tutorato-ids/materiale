//Facade
public class BattleRoyale {
	// Componenti del sottosistema
	CheatBuster cb = new CheatBuster();
	Server s = new Server(150);
	GiocatoriRegitrati gr = new GiocatoriRegitrati();
	
	public void registra(Giocatore g) {
		gr.registra(g);
	}
	
	public void partecipa(Giocatore g) {
		if (!gr.isRegistrato(g)) {
			System.out.println("Utente non registrato");
			return;
		}

		if (cb.isCheater(g)) {
			System.out.println("L'equip scelto non è consentito");
			return;
		}

		if (s.isPieno()) {
			System.out.println("Server pieno");
			return;
		}

		s.addGiocatore(g);
		System.out.println("Il giocatore è entrato in partita");
		
	}
	
	public void stato() {
		System.out.println(s);
	}
}
