package model;

import contract.Direction;

public abstract class Being extends Entity {
	
	protected Being(Character character, Position position) {
		super(character, position);
	}
	
	public Character getCharacter() {
		return (Character) element;
	}
	
	public void move(Direction direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	public void move(Position position) {}
}
