package model;

import Imodel.ICoordinates;
import Imodel.IDelimitations;

public class Delimitations implements IDelimitations {
	
	protected int xMin;
	protected int xMax;
	protected int yMin;
	protected int yMax;
	
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
	
	public boolean contains(ICoordinates coordinates) {
		if (coordinates.getX() >= xMin && coordinates.getX() <= xMax && coordinates.getY() >= yMin && coordinates.getY() <= yMax ) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass()) {
	        return false;
	    }
		
		Delimitations delimitations = (Delimitations) object;
		
		if (xMin == delimitations.getXMin() && xMax == delimitations.getXMax() && yMin == delimitations.getYMin() && yMax == delimitations.getYMax()) {
			return true;
		}
		
		return false;
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
