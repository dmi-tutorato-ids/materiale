// ha il ruolo di ConcreteCreator
public class Vulcano extends Dungeon {

	@Override
	protected Nemico getNemico(TipoNemico tipoNemico) {
		switch (tipoNemico) {
			case NORMALE:
				return new Goblin();
			case ELITE:
				return new Orco();
			case BOSS:
				return new Drago();
			default:
				return null;
		}
	}
	
}