package model;

import Imodel.IPosition;

public class Position extends Coordinates {
	private Tray tray;
	
	public Position(Tray tray, int x, int y) throws Exception {
		super(x, y);
		this.tray = tray;
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.Position(Dimension, int, int): Position outside of the tray.");
		}
	}
	
	public Position(Position position) {
		super(position);
		tray = position.tray;
	}

	public Position copy(IPosition position) {
		tray = (Tray) position.getTray();
		x = position.getX();
		y = position.getY();
		
		return this;
	}
	
	public Position next() throws Exception {
		if (x < tray.getBoundary().getXMax()) {
			x += 1;
		} else if (y < tray.getBoundary().getYMax()) {
			x = tray.getBoundary().getXMin();
			y += 1;
		} else {
			throw new Exception("Position.next(): Position is already at the end of the tray.");
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		return new String("Pos " + super.toString());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tray.getId();
		return result;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass()) {
	        return false;
	    }
		
		Position position = (Position) object;
		
		if (tray == position.tray) {
			if (super.equals(position)) {
				return true;
			}
		}
		
		return false;
	}

	public Position addition(Coordinates coordinates) throws Exception {
		x += coordinates.getX();
		y += coordinates.getY();
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
		
		return this;
	}
	
	public Position addition(Direction direction) throws Exception {
		
		switch (direction) {
			case UP:
				y -= 1;
				break;
			case RIGHT:
				x += 1;
				break;
			case DOWN:
				y += 1;
				break;
			case LEFT:
				x -= 1;
				break;
		}
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.addition(Position): New coordinates outside of the tray: " + toString());
		}
		
		return this;
	}
	
	public Position substraction(Coordinates coordinates) throws Exception {
		x -= coordinates.getX();
		y -= coordinates.getY();
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
		
		return this;
	}
	
	public Position substraction(Direction direction) throws Exception {
		switch (direction) {
			case UP:
				y += 1;
				break;
			case RIGHT:
				x -= 1;
				break;
			case DOWN:
				y -= 1;
				break;
			case LEFT:
				x += 1;
				break;
		}
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.substraction(Position): New coordinates outside of the tray.");
		}
		
		return this;
	}
	
	public Tray getTray() {
		return tray;
	}
}
