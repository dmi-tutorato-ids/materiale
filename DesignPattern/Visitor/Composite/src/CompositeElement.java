import java.util.ArrayList;
import java.util.List;

public class CompositeElement extends Element {
	List<Element> eList = new ArrayList<>();

	@Override
	public Element add(Element e) {
		if (! eList.contains(e))
			eList.add(e);
		return this;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this); // visit node
		eList.forEach(e -> e.accept(v)); // visit childs
	}

	public void operationComposite() {
		System.out.println("CompositeElement");
	}
	
}