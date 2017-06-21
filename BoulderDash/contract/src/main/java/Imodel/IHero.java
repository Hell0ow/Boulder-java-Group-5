package Imodel;

public interface IHero extends IBeing {

	public IObjective getObjective();
	
	public void move(IDirection direction);
	
	public void move(IPosition position);
	
}
