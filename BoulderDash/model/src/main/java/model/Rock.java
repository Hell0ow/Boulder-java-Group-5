package model;

import view.Assets;

public class Rock extends Block {
	public Rock() {
		super("Rock", Assets.rock);
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
