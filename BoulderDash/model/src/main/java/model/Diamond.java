package model;

import Imodel.IDiamond;

public class Diamond extends Block implements IDiamond {
	
	public Diamond() throws Exception{
		super("Diamond", "D:/CESI année 1/Projet/Java/Sprites/textures.png", new Coordinates(64, 0));
	}
	
	@Override
	public boolean isFallable() {
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
