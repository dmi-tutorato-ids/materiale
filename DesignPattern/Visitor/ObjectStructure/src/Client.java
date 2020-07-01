public class Client {
	public static void main(String[] args) {	
		/**
		 * ObjectStructure: {A, A, B}
		 */
		ObjectStructure s = new ObjectStructure()
			.add(new ConcreteElementA())
			.add(new ConcreteElementA())
			.add(new ConcreteElementB());

		System.out.println("# Run ConcreteVisitor1");
		s.accept(new ConcreteVisitor1());

		System.out.println("# Run ConcreteVisitor2");
		s.accept(new ConcreteVisitor2());
		
	}
	
}