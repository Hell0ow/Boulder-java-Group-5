package model;

public class Stone extends Block {
	public Stone() {
		super("Stone", 'S');
	}
	
	public boolean isAffectedByGravity() {
		return true;
	}
	
	public boolean isSmooth() {
		return true;
	}
}
