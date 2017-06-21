package model;

import Imodel.IBeing;

public abstract class Being extends Entity implements IBeing {
	
	protected Being(Character character, Position position) {
		super(character, position);
	}
	
	public ICharacter getCharacter() {
		return (ICharacter) element;
	}
	
	public void move(Direction direction) throws Exception {
		move(new Position((Position) position).addition(direction));
	}
	
	public void move(Position position) {}
}
