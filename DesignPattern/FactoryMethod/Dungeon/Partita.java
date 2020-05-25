import java.util.Random;

// ha il ruolo di Client
public class Partita {
	private static final int DANNO_MASSIMO = 10;
	
	private Dungeon dungeon;
	private int attacchi;

	public Partita(Dungeon dungeon, int attacchi) {
		this.dungeon = dungeon;
		this.attacchi = attacchi;
	}

	public void gioca() {
		Nemico nemico = dungeon.esplora();

		while (nemico != null && attacchi > 0) {
			int danno = getDannoAttacco();
			
			System.out.println(String.format("- Infliggo %d danni a: %s", danno, nemico.getNome()));
			nemico.applicaDanno(danno);
			
			if (nemico.isSconfitto()) {
				System.out.println(String.format("* %s sconfitto!", nemico.getNome()));
				nemico = dungeon.esplora();
			}
		}

		System.out.println(nemico == null ? "Vittoria" : "Sconfitta");

	}

	private int getDannoAttacco() {
		int danno = new Random().nextInt(DANNO_MASSIMO) + 1;
		attacchi--;
		return danno;
	}
}