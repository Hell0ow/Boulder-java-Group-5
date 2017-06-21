package model;

public abstract class Block extends Element {
	
	protected Block(String name, char texture, String path, Coordinates c) throws Exception {
		super(name, texture, path, c);
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
