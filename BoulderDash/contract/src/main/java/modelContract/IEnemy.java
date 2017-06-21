package modelContract;

public interface IEnemy {

	public IDummy getDummy();
	public void move() throws Exception;
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position);
}
