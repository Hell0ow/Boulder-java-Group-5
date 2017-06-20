package model;

public abstract class Entity {
	protected Position position;
	protected Element element;
	
	protected Entity(Element element, Position position) {
		this.element = element;
		this.position = position;
	}
	
	public Element getElement() {
		return element;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		
		this.position.copy(position);
	}
}
