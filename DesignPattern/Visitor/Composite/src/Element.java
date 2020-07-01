public abstract class Element {
	
	public Element add(Element e) {
		return this;
	}

	public abstract void accept(Visitor v);

}