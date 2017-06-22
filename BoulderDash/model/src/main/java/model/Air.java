package model;

import Imodel.IAir;

public class Air extends Block implements IAir {
	
	public Air() throws Exception {
		super("Air", "D:/CESI ann�e 1/Projet/Java/Sprites/textures.png", new Coordinates(32, 0));
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
