package model;

import modelContract.ICharacter;

public abstract class Character extends Element implements ICharacter {

	public Character(String name, char texture, String path, Coordinates c) throws Exception {
		super(name, texture, path, c);
	}
}
