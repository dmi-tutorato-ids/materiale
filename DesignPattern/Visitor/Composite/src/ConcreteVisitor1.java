// Override visit() methods only for the elements to be visited
public class ConcreteVisitor1 extends Visitor {
	@Override
	public void visit(CompositeElement e) {
		System.out.print("From ConcreteVisitor1: ");
		e.operationComposite();
	}

	@Override
	public void visit(ConcreteElementA e) {
		System.out.print("From ConcreteVisitor1: ");
		e.operationA();
	}
}