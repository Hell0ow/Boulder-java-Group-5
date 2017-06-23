package Imodel;

public interface IPosition extends ICoordinates {
	
	public IPosition copy(IPosition position);
	
	public IPosition next() throws Exception;
	
	@Override
	public String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object object);

	public IPosition addition(ICoordinates coordinates) throws Exception;
	
	public IPosition addition(IDirection direction) throws Exception;
	
	public IPosition substraction(ICoordinates coordinates) throws Exception;
	
	public IPosition substraction(IDirection direction) throws Exception;
	
	public ITray getTray();
}
