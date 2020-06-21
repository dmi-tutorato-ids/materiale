// Concrete Implementor
public class P1Drawing implements Drawing {
	@Override
	public void drawLine() {
		System.out.println("- Draw a line using P1 APIs");
	}

	@Override
	public void drawCircle() {
		System.out.println("- Draw a circle using P1 APIs");
	}

}
