public class ConcreteElementB extends Element {
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void operationB() {
		System.out.println("ConcreteElementB");
	}
	
}