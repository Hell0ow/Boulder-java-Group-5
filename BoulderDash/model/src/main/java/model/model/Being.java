package model;

public abstract class Being extends Entity {
	
	protected Being(Character character, Position position) {
		super(character, position);
	}
	
	public Character getCharacter() {
		return (Character) element;
	}
}
