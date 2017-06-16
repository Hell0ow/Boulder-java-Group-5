package model;

public class Rock extends Block {
	public Rock() {
		super("Rock", 'R');
	}
	
	@Override
	public boolean isAffectedByGravity() {
		return true;
	}
	
	@Override
	public boolean isSmooth() {
		return true;
	}
}
