package Imodel;

public interface IHero extends IBeing {

	public IObjective getObjective();
	
	public void move(IDirection direction) throws Exception;
	
	public void move(IPosition position);
	
}
