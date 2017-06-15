package model;

public class Position {
	private Coordinates coordinates;
	private Tray tray;
	
	public Position(Tray tray, Coordinates coordinates) throws Exception {
		this.coordinates = coordinates;
		this.tray = tray;
		
		if (!tray.getBoundary().countains(this)) {
			throw new Exception("Position.Position(Dimension, int, int): Position outside of the tray.");
		}
	}
	
	public Position(Position position) {
		coordinates = new Coordinates(position.coordinates);
		tray = position.tray;
	}
	
	public Position next() throws Exception {
		if (coordinates.getX() < tray.getBoundary().getDelimitations().getXMax()) {
			coordinates.setX(coordinates.getX() + 1);
		} else if (coordinates.getY() < tray.getBoundary().getDelimitations().getYMax()) {
			coordinates.setX(tray.getBoundary().getDelimitations().getXMin());
			coordinates.setY(coordinates.getY() + 1);
		} else {
			throw new Exception("Position.next(): Position is already at the end of the tray.");
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		return new String("Pos " + coordinates);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
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
			if (coordinates.equals(position.getCoordinates())) {
				return true;
			}
		}
		
		return false;
	}

	public Position addition(Coordinates coordinates) throws Exception {
		this.coordinates.addition(coordinates);
		
		if (!tray.getBoundary().countains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
		
		return this;
	}
	
	public Position subtraction(Coordinates coordinates) throws Exception {
		this.coordinates.substraction(coordinates);
		
		if (!tray.getBoundary().countains(this)) {
			throw new Exception("Position.addition(Coordinates): New coordinates outside of the tray.");
		}
		
		return this;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(Coordinates coordinates) throws Exception {
		this.coordinates = coordinates;
	}
	
	public Tray getTray() {
		return tray;
	}
}
