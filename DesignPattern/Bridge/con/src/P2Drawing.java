// Concrete Implementor
public class P2Drawing implements Drawing {
	@Override
	public void drawLine() {
		System.out.println("- Draw a line using P2 APIs");
	}
	
	@Override
	public void drawCircle() {
		System.out.println("- Draw a circle using P2 APIs");
	}

}
