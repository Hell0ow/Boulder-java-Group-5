package model;

public interface IModel {

	public ILevel getLevel();
	
	public IPlayer getPlayer();
	
	public void setPlayer(IPlayer player);
	
	public void cycle(IOrder order);
}
