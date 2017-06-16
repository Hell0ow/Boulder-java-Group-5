package model;

public class Enemy extends Being {
	public Enemy(Dummy dummy, Position position) {
		super(dummy, position);
	}
	
	public Dummy getDummy() {
		return (Dummy) element;
	}
}
