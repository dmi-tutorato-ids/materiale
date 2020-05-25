public class Fucile implements Arma {
	private Munizioni m;

	public Fucile(Munizioni m) {
		this.m = m;
	}

	@Override
	public String getTipo() {
		return "Fucile";
	}

	@Override
	public int getDannoArea() {
		return 100 * m.getMoltiplicatoreDanno();
	}

	@Override
	public int getDannoMirato() {
		return 20 * m.getMoltiplicatoreDanno();
	}
	
}