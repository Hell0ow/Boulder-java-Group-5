package model;

import Imodel.IWall;

public class Wall extends Block implements IWall {
	
	public Wall() throws Exception{
		super("Wall", 'W', "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(0, 0));
	}
}
