// Abstraction
public abstract class Shape {
	// Riferimento ad un Implementor (a seconda della Piattaforma)
	private Drawing impl;
	
	public Shape(Drawing impl) {
		this.impl = impl;
	}
	
	// Metodo per interagire con l'Implementazione
	protected void drawLine() {
		impl.drawLine();
	}
	
	// Metodo per interagire con l'Implementazione
	protected void drawCircle() {
		impl.drawCircle();
	}
	
	// Medoto ridefinito dalla Refined Abstraction
	public abstract void draw();
	
}
