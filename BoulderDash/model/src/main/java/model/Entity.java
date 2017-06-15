package model;

public abstract class Entity {
	protected Position position;
	
	protected Entity(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = new Position(position);
	}
}
