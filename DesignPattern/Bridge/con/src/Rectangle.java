// Refined Abstraction
public class Rectangle extends Shape {

	public Rectangle(Drawing impl) {
		super(impl);
	}

	/**
	 * Metodo definito dall'Astrazione
	 * la superclasse fa da "ponte" verso l'Implementazione
	 */
	@Override
	public void draw() {
		System.out.println("\nDraw a Rectangle:"); 
		drawLine();
		drawLine();
		drawLine();
		drawLine();
	}

}
