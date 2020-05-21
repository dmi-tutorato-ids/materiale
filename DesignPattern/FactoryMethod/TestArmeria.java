public class TestArmeria {
	public static void main(String[] args) {
		Arma a = Armeria.getFucilePesante();
		Arma b = Armeria.getPistolaOrdinanza();

		System.out.println("Danno ad area " + a.getTipo() + ": " + a.getDannoArea());
		System.out.println("Danno colpo mirato " + a.getTipo() + ": " + a.getDannoMirato());

		System.out.println("Danno ad area " + b.getTipo() + ": " + b.getDannoArea());
		System.out.println("Danno colpo mirato " + b.getTipo() + ": " + b.getDannoMirato());
	}
}