package model;

import Imodel.ICharacter;

public abstract class Character extends Element implements ICharacter {

	public Character(String name, String path, Coordinates c) throws Exception {
		super(name, path, c);
	}
}
