public class Balancer {
	private String[] hosts = new String[]{"host1", "host2", "host3"};
	private int x;
	private static Balancer b = new Balancer();
	
	private Balancer() {
		x = 0;
	}

	public static Balancer getInstance() {
		return b;
	}

	public String getHost() {
		if (x == hosts.length) x = 0;
		return hosts[x++];
	}
}