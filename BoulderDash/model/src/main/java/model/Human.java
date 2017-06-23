package model;

import Imodel.IHuman;

public class Human extends Character implements IHuman {

	public Human() throws Exception {
		super("Human", "D:/CESI année 1/Projet/Java/Sprites/human.png", new Coordinates(48, 64));
	}
}
