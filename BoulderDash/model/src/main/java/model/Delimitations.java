package model;

public class Delimitations {
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;
	
	public Delimitations(int xMin, int xMax, int yMin, int yMax) throws Exception {
		if (xMin > xMax || yMin > yMax) {
			throw new Exception("Delimitations.Delimitations(int, int, int, int): Illogical limits.");
		}
			
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	
	public Delimitations(Delimitations delimitations) {
		xMin = delimitations.xMin;
		xMax = delimitations.xMax;
		yMin = delimitations.yMin;
		yMax = delimitations.yMax;
	}
	
	public boolean contains(Coordinates coordinates) {
		if (coordinates.getX() >= xMin && coordinates.getX() <= xMax && coordinates.getY() >= yMin && coordinates.getY() <= yMax ) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals(Delimitations delimitations) {
		return xMin == delimitations.xMin && xMax == delimitations.xMax && yMin == delimitations.yMin && yMax == delimitations.yMax;
	}
	
	public int getXMin() {
		return xMin;
	}
	
	public int getXMax() {
		return xMax;
	}
	
	public int getYMin() {
		return yMin;
	}
	
	public int getYMax() {
		return yMax;
	}
}
