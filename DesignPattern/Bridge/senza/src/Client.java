public class Client {
	public static void main(String[] args) {
		// Piattaforma 1
		Creator crt1 = new Creator("P1");
		Shape r1 = crt1.getRectangle();
		Shape c1 = crt1.getCircle();
		r1.draw();
		c1.draw();
		
		// Piattaforma 2
		Creator crt2 = new Creator("P2");
		Shape r2 = crt2.getRectangle();
		Shape c2 = crt2.getCircle();
		r2.draw();
		c2.draw();
		
	}

}
