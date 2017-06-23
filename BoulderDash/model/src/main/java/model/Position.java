package model;

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

	@Override
	public void addition(Coordinates coordinates) throws Exception {
		super.addition(coordinates);
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
	}
	
	@Override
	public void substraction(Coordinates coordinates) throws Exception {
		super.substraction(coordinates);
		
		if (!tray.getBoundary().contains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
	}
	
	public Tray getTray() {
		return tray;
	}
}
