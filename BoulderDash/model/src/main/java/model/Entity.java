package model;

public abstract class Entity {
	protected IPosition position;
	protected IElement element;
	
	protected Entity(IBlock block, IPosition position) {
		this.element = block;
		this.position = position;
	}
	
	public IElement getElement() {
		return element;
	}
	
	public IPosition getPosition() {
		return position;
	}
	
	public void setPosition(IPosition position) {
		
		this.position.copy(position);
	}
}
