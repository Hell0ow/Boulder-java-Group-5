package model;

import Imodel.IHuman;

public class Human extends Character implements IHuman {

	public Human() throws Exception {
		super("Human", "C:/Users/MMoul/desktop/Player.png", new Coordinates(48, 64));
	}
}
