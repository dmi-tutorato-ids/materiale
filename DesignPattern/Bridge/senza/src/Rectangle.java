public abstract class Rectangle implements Shape {

	// Metodo definito dall'Astrazione
	@Override
	public void draw() {
		System.out.println("\nDraw a Rectangle with 4 lines:"); 
		drawLine();
		drawLine();
		drawLine();
		drawLine();
	}
	
	// Metodo per interagire con l'Implementazione
	public abstract void drawLine();

}
