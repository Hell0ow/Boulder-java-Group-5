package model;

public abstract class Block extends Element {
	
	protected Block(String name, char texture) {
		super(name, texture);
	}
	
	public boolean isAffectedByGravity() {
		return false;
	}
	
	public boolean isDense() {
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
