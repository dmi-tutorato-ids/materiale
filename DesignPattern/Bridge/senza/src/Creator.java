public class Creator {
	private String platform;
	
	public Creator(String platform) {
		this.platform = platform;
	}
	
	public Shape getRectangle() {
		switch (platform) {
			case "P1": return new P1Rectangle();
			case "P2": return new P2Rectangle();
			default: 
				System.out.println("Piattaforma non supportata"); 
				return null;
		}
	}
	
	public Shape getCircle() {
		switch (platform) {
			case "P1": return new P1Circle();
			case "P2": return new P2Circle();
			default: 
				System.out.println("Piattaforma non supportata"); 
				return null;
		}
	}
}
