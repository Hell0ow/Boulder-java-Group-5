package model;

public class Rock extends Block {
	public Rock() {
		super("Rock", 'R');
	}
	
	public boolean isDense() {
		return true;
	}
	
	public boolean isDiggeable() {
		return true;
	}
}
