package modelContract;

public interface IBeing {

	public Character getCharacter();
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position);
	
}
