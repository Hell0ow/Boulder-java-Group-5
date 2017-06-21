package model;

public interface IPosition extends ICoordinates {
	
	public IPosition copy(IPosition position);
	
	public IPosition next();
	
	@Override
	public String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object object);

	public IPosition addition(ICoordinates coordinates);
	
	public IPosition addition(Direction direction);
	
	public IPosition substraction(ICoordinates coordinates);
	
	public IPosition substraction(Direction direction);
	
	public ITray getTray();
}
