package Imodel;

public interface IBeing extends IEntity {

	public ICharacter getCharacter();
	
	public void move(Direction direction);
	
	public void move(IPosition position);
	
}
