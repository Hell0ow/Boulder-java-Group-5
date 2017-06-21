package model;

import model.IDirection;
import model.IPosition;

public interface IBeing {

	public Character getCharacter();
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position);
	
}
