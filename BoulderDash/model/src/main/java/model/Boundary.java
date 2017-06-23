package model;

public class Boundary {
	private Delimitations delimitations;
	private Tray tray;
	
	public Boundary(Tray tray, Delimitations delimitations) {
		this.delimitations = delimitations;
		this.tray = tray;
	}
	
	public Boundary(Boundary boundary) {
		delimitations = new Delimitations(boundary.getDelimitations());
		tray = boundary.getTray();
	}
	
	public Position getMinPosition() throws Exception {
		return new Position(tray, new Coordinates(delimitations.getXMin(), delimitations.getYMin()));
	}
	
	public Position getMaxPosition() throws Exception {
		return new Position(tray, new Coordinates(delimitations.getXMax(), delimitations.getYMax()));
	}
	
	public boolean contains(Position position) {
		if (tray == position.getTray()) {
			if (delimitations.contains(position.getCoordinates())) {
				return true;
			}
		}
			
		return false;
	}
	
	public boolean equals(Boundary boundary) {
		if (tray == boundary.getTray()) {
			if (delimitations.equals(boundary.getDelimitations())) {
				return true;
			}
		}
		
		return false;
	}
	
	public Delimitations getDelimitations() {
		return delimitations;
	}
	
	public Tray getTray() {
		return tray;
	}
}
