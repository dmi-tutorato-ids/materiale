// Override visit() methods only for the elements to be visited
public class ConcreteVisitor2 extends Visitor {
	@Override
	public void visit(CompositeElement e) {
		System.out.print("From ConcreteVisitor2: ");
		e.operationComposite();
	}

	@Override
	public void visit(ConcreteElementB e) {
		System.out.print("From ConcreteVisitor2: ");
		e.operationB();
	}
}