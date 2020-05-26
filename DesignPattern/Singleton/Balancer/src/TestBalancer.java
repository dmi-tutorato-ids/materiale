public class TestBalancer {

	public static void main(String[] args) {
		Balancer b = Balancer.getInstance();
		for (int i = 0; i < 9; i++) {
			System.out.println("Call: " + b.getHost());
		}
	}
	
}