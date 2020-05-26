public class Pistola implements Arma {
	private Munizioni m;

	public Pistola(Munizioni m) {
		this.m = m;
	} 

	@Override
	public String getTipo() {
		return "Pistola";
	}

	@Override
	public int getDannoArea() {
		return 20 * m.getMoltiplicatoreDanno();
	}

	@Override
	public int getDannoMirato() {
		return 50 * m.getMoltiplicatoreDanno();
	}

}
