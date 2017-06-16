package model;

public class Diamond extends Block {
	public Diamond() {
		super("Diamond", 'D');
	}
	
	@Override
	public boolean isAffectedByGravity() {
		return true;
	}
	
	@Override
	public boolean isBreakable() {
		return true;
	}
	
	@Override
	public boolean isSmooth() {
		return true;
	}
	
	@Override
	public boolean isReward() {
		return true;
	}
}
