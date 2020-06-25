public class App {
	public static void main(String[] args) {
		// Assemble all the pieces of the MVC
		Model m = new Model(10);
		
		View v1 = new View("View 1");
		v1.setModel(m);
		v1.setController(new Controller(m, v1));

		View v2 = new View("View 2");
		v2.setModel(m);
		v2.setController(new Controller(m, v2));
	}
}