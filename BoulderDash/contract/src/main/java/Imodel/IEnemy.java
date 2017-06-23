package Imodel;

public interface IEnemy extends IBeing {

	public IDummy getDummy();
	public void move() throws Exception;
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position) throws Exception;
}
