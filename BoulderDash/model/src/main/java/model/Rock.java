package model;

import Imodel.IRock;

public class Rock extends Block implements IRock {
	
	public Rock() throws Exception {
		super("Rock", "D:/CESI ann�e 1/Projet/Java/Sprites/textures.png", new Coordinates(48, 0));
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
	
	@Override
	public boolean isSmooth() {
		return true;
	}
}
