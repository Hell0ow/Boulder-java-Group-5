package model;

import view.Assets;

public class Air extends Block {
	public Air() {
		super("Air", Assets.air);
	}
	
	@Override
	public boolean isBreakable() {
		return false;
	}
	
	@Override
	public boolean isDense() {
		return false;
	}
}
