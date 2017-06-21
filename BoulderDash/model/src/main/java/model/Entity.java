package model;

import Imodel.IBlock;
import Imodel.IElement;
import Imodel.IPosition;

public abstract class Entity {
	
	protected Position position;
	protected Element element;
	
	protected Entity(Character character, Position position2) {
		this.element = (Element) character;
		this.position = (Position) position2;
	}
	
	public Entity(IBlock iBlock, IPosition iPosition) {
		// TODO Auto-generated constructor stub
	}

	public IElement getElement() {
		return (IElement) element;
	}
	
	public Position getPosition() {
		return (Position) position;
	}
	
	public void setPosition(IPosition position) {
		this.position.copy(position);
	}
}
