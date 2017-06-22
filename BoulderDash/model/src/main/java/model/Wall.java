package model;

import Imodel.IWall;

public class Wall extends Block implements IWall {
	
	public Wall() throws Exception{
		super("Wall", "D:/CESI ann�e 1/Projet/Java/Sprites/textures.png", new Coordinates(0, 0));
	}
	
	@Override
	public boolean isBreakable() {
		return false;
	}
}
