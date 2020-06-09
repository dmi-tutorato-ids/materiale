public class TestPietanza {
	public static void main(String[] args) {
		// Spaghetti fatti in casa
		Pietanza spaghetti = Dispensa.getPreparato("spaghetti")
			.add(Dispensa.getIngrediente("farina", 80))
			.add(Dispensa.getIngrediente("sale", 5))
			.add(Dispensa.getIngrediente("acqua", 50));

		// Condimento
		Pietanza condimento = Dispensa.getPreparato("condimento")
			.add(Dispensa.getIngrediente("aglio", 3))
			.add(Dispensa.getIngrediente("olio", 10))
			.add(Dispensa.getIngrediente("peperoncino", 1));

		// Mostro lista ingredienti
		Pietanza pranzo = Dispensa.getPreparato("spaghetti aglio olio e peperoncino")
			.add(spaghetti)
			.add(condimento);

		// Mostro calorie totali
		pranzo.mostra();
		System.out.println("Calorie totali: " + pranzo.calcolaCalorie());

		// Troppe calorie, tolgo il condimento
		pranzo.remove(condimento)
			.setNome("spaghetti e basta")
			.mostra();
		System.out.println("Calorie totali: " + pranzo.calcolaCalorie());
	}
}