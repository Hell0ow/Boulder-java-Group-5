package model;

import Imodel.IRock;
import Imodel.IWall;

public class Wall extends Block implements IWall {
	
	public Wall() throws Exception{
		super("Wall", "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(0, 0));
	}
}
