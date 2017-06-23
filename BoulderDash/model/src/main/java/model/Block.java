package model;

import Imodel.IBlock;

public abstract class Block extends Element implements IBlock {
	
	protected Block(String name, String path, Coordinates c) throws Exception {
		super(name, path, c);
	}
	
	public boolean isBreakable() {
		return true;
	}
	
	public boolean isDense() {
		return true;
	}
	
	public boolean isFallable() {
		return false;
	}
	
	public boolean isDiggeable() {
		return false;
	}
	
	public boolean isSmooth() {
		return false;
	}
	
	public boolean isReward() {
		return false;
	}
}
