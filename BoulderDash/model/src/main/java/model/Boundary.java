package model;

import Imodel.IBoundary;

public class Boundary extends Delimitations implements IBoundary {
	private Tray tray;
	
	public Boundary(Tray tray, int xMin, int xMax, int yMin, int yMax) throws Exception {
		super(xMin, xMax, yMin, yMax);
		this.tray = tray;
	}
	
	public Boundary(Tray tray, Delimitations delimitations) {
		super(delimitations);
		this.tray = tray;
	}
	
	public Boundary(Boundary boundary) {
		super(boundary);
		tray = boundary.getTray();
	}
	public Position getMinPosition() throws Exception {
		return new Position(tray, xMin, yMin);
	}
	
	public Position getMaxPosition() throws Exception {
		return new Position(tray, xMax, yMax);
	}
	
	public boolean contains(Position position) {
		if (tray == position.getTray()) {
			if (super.contains(position)) {
				return true;
			}
		}
			
		return false;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass()) {
	        return false;
	    }
		
		Boundary boundary = (Boundary) object;
		
		if (tray == boundary.tray) {
			if (super.equals(boundary)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Tray getTray() {
		return tray;
	}
}
