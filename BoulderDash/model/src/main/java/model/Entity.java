package model;

import Imodel.IElement;
import Imodel.IPosition;

public abstract class Entity {
	
	protected Position position;
	protected Element element;
	
	protected Entity(Element element, Position position) {
		this.element = element;
		this.position = position;
	}
	
	public IElement getElement() {
		return (IElement) element;
	}
	
	public IPosition getPosition() {
		return (IPosition) position;
	}
	
	public void setPosition(IPosition position) {
		this.position.copy(position);
	}
}
