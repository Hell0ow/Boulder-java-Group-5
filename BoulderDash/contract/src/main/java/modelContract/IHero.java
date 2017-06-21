package modelContract;

public interface IHero {

	public IObjective getObjective();
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position);
	
}
