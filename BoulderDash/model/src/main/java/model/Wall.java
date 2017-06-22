package model;

import Imodel.IWall;

public class Wall extends Block implements IWall {
	
	public Wall() throws Exception{
		super("Wall", "C:/Users/MMoul/desktop/blocks.png", new Coordinates(0, 0));
	}
	
	@Override
	public boolean isBreakable() {
		return false;
	}
}
