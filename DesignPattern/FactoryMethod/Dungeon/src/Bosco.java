// ha il ruolo di ConcreteCreator
public class Bosco extends Dungeon {
	@Override
	protected Nemico getNemico(TipoNemico tipoNemico) {
		switch (tipoNemico) {
			case NORMALE: return new Goblin();
			case ELITE: return new Goblin();
			case BOSS: return new Orco();
			default: return null;
		}
	}
	
}