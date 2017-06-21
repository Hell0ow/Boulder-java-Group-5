package model;

public interface ITile extends IEntity {
	
	public IBlock getBlock();
	
	public boolean dig();
	
	public boolean fall() throws Exception;
}
