package model;

import java.awt.image.BufferedImage;

public abstract class Block extends Element {
	
	protected Block(String name, BufferedImage texture) {
		super(name, texture);
	}
	
	public boolean isBreakable() {
		return true;
	}
	
	public boolean isDense() {
		return true;
	}
	
	public boolean isAffectedByGravity() {
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
