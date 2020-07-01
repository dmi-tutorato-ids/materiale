public class Client {
	public static void main(String[] args) {	
		/**
		 * Comp
		 *  +- A
		 *  +- Comp
		 *      +- A
		 * 		+- B 
		 */
		Element e = new CompositeElement()
			.add(new ConcreteElementA())
			.add(new CompositeElement()
				.add(new ConcreteElementA())
				.add(new ConcreteElementB()));

		System.out.println("# Run ConcreteVisitor1");
		e.accept(new ConcreteVisitor1());

		System.out.println("# Run ConcreteVisitor2");
		e.accept(new ConcreteVisitor2());
		
	}
	
}