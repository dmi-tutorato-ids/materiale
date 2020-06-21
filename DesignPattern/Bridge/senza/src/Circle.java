public abstract class Circle implements Shape {

	// Metodo definito dall'Astrazione
	@Override
	public void draw() {
		System.out.println("\nDraw a Circle:"); 
		drawCircle();
	}
	
	// Metodo per interagire con la Piattaforma
	public abstract void drawCircle();

}
