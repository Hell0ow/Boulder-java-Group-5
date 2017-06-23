package Imodel;

public interface ITile extends IEntity {
	
	public IBlock getBlock();
	
	public boolean destroy();
	
	public boolean dig();
	
	public boolean fall() throws Exception;
}
