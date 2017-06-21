package modelContract;

public interface IObjective {
	
	public boolean isCompleted();
	
	public IHero getHero();
	
	public void setHero(IHero hero);
	
	public IPlayer getPlayer();
	
	public int getObtained();
	
	public void setObtained(int obtained);
	
	public int getRequired();

}
