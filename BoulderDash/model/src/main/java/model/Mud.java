package model;

import Imodel.IMud;

public class Mud extends Block implements IMud {
	
	public Mud() throws Exception {
		super("Mud", "D:/CESI ann�e 1/Projet/Java/Sprites/textures.png", new Coordinates(16, 0));
	}
	
	@Override
	public boolean isDiggeable() {
		return true;
	}
}
