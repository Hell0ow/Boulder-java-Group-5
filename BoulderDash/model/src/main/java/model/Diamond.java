package model;

public class Diamond extends Block {
	public Diamond() {
		super("Diamond", 'D');
	}
	
	public boolean isAffectedByGravity() {
		return true;
	}
		
	public boolean isSmooth() {
		return true;
	}
}
