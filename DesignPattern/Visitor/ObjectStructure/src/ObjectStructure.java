import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
	List<Element> eList = new ArrayList<>();

	public ObjectStructure add(Element e) {
		if (! eList.contains(e))
			eList.add(e);
		return this;
	}

	public void accept(Visitor v) {
		eList.forEach(e -> e.accept(v)); // visit elements
	}
	
}