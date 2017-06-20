package model;

import view.Assets;

public class Diamond extends Block {
	public Diamond() {
		super("Diamond", Assets.diamond);
	}
	
	@Override
	public boolean isAffectedByGravity() {
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
