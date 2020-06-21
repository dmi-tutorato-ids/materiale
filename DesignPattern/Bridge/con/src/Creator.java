public class Creator {
	private String platform;

	public Creator(String platform) {
		this.platform = platform;
	}

	public Shape getRectangle() {
		switch (platform) {
		case "P1":
			return new Rectangle(new P1Drawing());
		case "P2":
			return new Rectangle(new P2Drawing());
		default:
			System.out.println("Piattaforma non supportata");
			return null;
		}
	}

	public Shape getCircle() {
		switch (platform) {
		case "P1":
			return new Circle(new P1Drawing());
		case "P2":
			return new Circle(new P2Drawing());
		default:
			System.out.println("Piattaforma non supportata");
			return null;
		}
	}
}
