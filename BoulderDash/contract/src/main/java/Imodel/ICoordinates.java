package Imodel;

public interface ICoordinates {

	@Override
	public String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object object);
	
	public int getX();

	public void setX(int x);
	
	public int getY();

	public void setY(int y);
}
