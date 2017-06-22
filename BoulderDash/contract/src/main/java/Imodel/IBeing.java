package Imodel;

public interface IBeing extends IEntity {

	public ICharacter getCharacter();
	
	public void destroy();
	
	public void explode() throws Exception;
	
	public void move(IDirection direction) throws Exception;
	
	public void move(IPosition position);
}
