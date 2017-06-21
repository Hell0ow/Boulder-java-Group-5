package Imodel;

public interface IHero extends IBeing {

	public IObjective getObjective();
	
	public void move(Direction direction);
	
	public void move(IPosition position);
	
}
