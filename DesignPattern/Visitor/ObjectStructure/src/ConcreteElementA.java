public class ConcreteElementA implements Element {
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void operationA() {
		System.out.println("ConcreteElementA");
	}
}