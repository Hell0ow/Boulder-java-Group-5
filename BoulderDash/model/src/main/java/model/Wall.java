package model;

import Imodel.IRock;
import Imodel.IWall;

public class Wall extends Block implements IWall {
	
	public Wall() throws Exception{
		super("Wall", "D:/CESI année 1/Projet/Java/Sprites/textures.png", new Coordinates(0, 0));
	}
}
