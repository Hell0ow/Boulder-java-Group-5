package model;

public class Coordinates {
	protected int x;
	protected int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinates(Coordinates coordinates) {
		x = coordinates.x;
		y = coordinates.y;
	}
	
	@Override
	public String toString() {
		return new String("x: " + x + " y: " + y);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass()) {
	        return false;
	    }
		
		Coordinates coordinates = (Coordinates) object;
		
		return x == coordinates.getX() && y == coordinates.getY();
	}

	public void addition(Coordinates coordinates) throws Exception {
		x += coordinates.getX();
		y += coordinates.getY();
	}
	
	public void substraction(Coordinates coordinates) throws Exception {
		x -= coordinates.getX();
		y -= coordinates.getY();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
