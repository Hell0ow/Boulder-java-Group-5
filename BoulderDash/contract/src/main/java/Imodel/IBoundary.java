package Imodel;

public interface IBoundary extends IDelimitations {

	public IPosition getMinPosition() throws Exception;
	
	public IPosition getMaxPosition() throws Exception;
	
	public boolean contains(IPosition position);
	
	@Override
	public boolean equals(Object object);
	
	public ITray getTray();
	
}
