package model;

import Imodel.IBoundary;
import Imodel.ICoordinates;
import Imodel.IDelimitations;
import Imodel.IPosition;
import Imodel.ITray;

public class Boundary extends Delimitations implements IBoundary {
	private Tray tray;
	
	public Boundary(Tray tray, int xMin, int xMax, int yMin, int yMax) throws Exception {
		super(xMin, xMax, yMin, yMax);
		this.tray = tray;
	}
	
	public Boundary(ITray tray2, IDelimitations delimitations) {
		super((Delimitations) delimitations);
		this.tray = (Tray) tray2;
	}
	
	public Boundary(Boundary boundary) {
		super(boundary);
		tray = boundary.getTray();
	}
	public IPosition getMinPosition() throws Exception {
		return (IPosition) new Position(tray, xMin, yMin);
	}
	
	public IPosition getMaxPosition() throws Exception {
		return (IPosition) new Position(tray, xMax, yMax);
	}
	
	public boolean contains(IPosition position) {
		if (tray == position.getTray()) {
			if (super.contains((ICoordinates) position)) {
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
