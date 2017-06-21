package Imodel;

public interface IBeing extends IEntity {

	public Character getCharacter();
	public void move(Direction direction);
	public void move(IPosition position);
	
}
