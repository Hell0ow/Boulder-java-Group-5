package model;

import view.Assets;

public class Mud extends Block {
	public Mud() {
		super("Mud", Assets.mud);
	}
	
	@Override
	public boolean isDiggeable() {
		return true;
	}
}
