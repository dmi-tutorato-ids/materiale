public class TestPietanzaEsteso {
	/*
	 * !!! DISCLAIMER !!! Le dosi proposte di seguito sono state inserite solo a
	 * titolo esemplificativo, e non sono da intendersi come dosi veritiere. Il
	 * sottoscritto declina ogni responsabilitÃ relativa ad indigestioni o
	 * allucinazioni per overdose da burro. !!! Don't try this at home !!!
	 */
	public static void main(String[] args) {
		// Ispirati dal nuovo canale su YouTube di MastroCuoco
		// vogliamo cimentarci nella preparazione di autentiche
		// tagliatelle alla bolognese, fatte in casa!
		// Stando pero' sempre attenti alla lista ingredienti
		// e alle calorie totali! (Summer is coming)

		// Prendiamo nota degli ingredienti per le tagliatelle
		Pietanza tagliatelle = Dispensa.getPreparato("tagliatelle")
			.add(Dispensa.getIngrediente("farina", 80))
			.add(Dispensa.getIngrediente("uova", 20))
			.add(Dispensa.getIngrediente("sale", 5))
			.add(Dispensa.getIngrediente("acqua", 50));

		// Per la salsa
		Pietanza salsa = Dispensa.getPreparato("salsa")
			.add(Dispensa.getIngrediente("pomodoro", 60))
			.add(Dispensa.getIngrediente("olio", 10))
			.add(Dispensa.getIngrediente("aglio", 3))
			.add(Dispensa.getIngrediente("basilico", 3));

		// E per il macinato alla cipolla
		Pietanza macinato = Dispensa.getPreparato("macinato alla cipolla")
				.add(Dispensa.getIngrediente("macinato", 80))
				.add(Dispensa.getIngrediente("cipolla", 50))
				.add(Dispensa.getIngrediente("olio", 10))
				.add(Dispensa.getIngrediente("pepe", 2))
				.add(Dispensa.getIngrediente("sale", 3));

		// Mettiamo assieme la salsa e il macinato,
		// e giusto un po' di burro, per preparare il ragu
		Pietanza ragu = Dispensa.getPreparato("ragu")
			.add(macinato)
			.add(salsa)
			.add(Dispensa.getIngrediente("burro", 50));

		// Tutto e' pronto per le nostre tagliatelle alla bolognese!
		Pietanza bolognese = Dispensa.getPreparato("tagliatelle alla bolognese")
			.add(tagliatelle)
			.add(ragu);

		// Euforici, mostriamo la lista ingredienti e le calorie totali
		bolognese.mostra();
		System.out.println("Calorie totali: " + bolognese.calcolaCalorie());

		// All'improvviso, il dramma!
		// Abbiamo dimenticato di comprare il macinato. Tutto sembra perduto.
		// Togliamo il ragu e mostriamo nuovamente ingredienti e calorie
		bolognese.remove(ragu);
		System.out.println();
		bolognese.mostra();
		System.out.println("Calorie totali: " + bolognese.calcolaCalorie());

		// Ma proprio quando abbiamo perso ogni speranza,
		// dietro la scorta annuale di lenticchie troviamo
		// una lattina di funghi in scatola e della panna da cucina del '48!
		// Si passa al piano B: tagliatelle ai funghi!
		// Prepariamo la lista per la salsa "panna e funghi"
		Pietanza salsaFunghi = Dispensa.getPreparato("salsa panna e funghi")
				.add(Dispensa.getIngrediente("panna", 40))
				.add(Dispensa.getIngrediente("funghi", 40))
				.add(Dispensa.getIngrediente("olio", 10))
				.add(Dispensa.getIngrediente("prezzemolo", 5))
				.add(Dispensa.getIngrediente("parmigiano", 20));

		// E aggiungiamo la salsa al piatto di prima...
		bolognese.add(salsaFunghi);
		System.out.println();
		bolognese.mostra();
		System.out.println("Calorie totali: " + bolognese.calcolaCalorie());

		// Tutto e pronto! Si cucina!!! Buon appetito!
	}
}