// Refined Abstraction
public class Circle extends Shape {

	public Circle(Drawing impl) {
		super(impl);
	}

	/**
	 * Metodo definito dall'Astrazione
	 * la superclasse fa da "ponte" verso l'Implementazione
	 */
	@Override
	public void draw() {
		System.out.println("\nDraw a Circle:"); 
		drawCircle();
	}

}
