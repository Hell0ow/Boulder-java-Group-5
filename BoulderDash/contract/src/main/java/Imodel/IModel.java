package Imodel;public interface IModel {
	public ILevel getLevel();
	public IPlayer getPlayer();	
	public void setPlayer(IPlayer player);		public void finish();	
	public boolean cycle(IOrder order) throws Exception;
}
