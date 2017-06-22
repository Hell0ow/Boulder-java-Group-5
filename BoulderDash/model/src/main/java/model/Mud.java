package model;

import Imodel.IMud;

public class Mud extends Block implements IMud {
	
	public Mud() throws Exception {
		super("Mud", "C:/Users/MMoul/desktop/blocks.png", new Coordinates(16, 0));
	}
	
	@Override
	public boolean isDiggeable() {
		return true;
	}
}
