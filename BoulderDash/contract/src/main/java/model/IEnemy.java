package model;

public interface IEnemy extends IBeing {

	public IDummy getDummy();
	public void move() throws Exception;
	public void move(Direction direction);
	public void move(IPosition position);
}
