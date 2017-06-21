package Imodel;

public interface IDelimitations {
	
	public boolean contains(ICoordinates coordinates);
	
	@Override
	public boolean equals(Object object);
	
	public int getXMin();
	
	public int getXMax();
	
	public int getYMin();
	
	public int getYMax();
}
