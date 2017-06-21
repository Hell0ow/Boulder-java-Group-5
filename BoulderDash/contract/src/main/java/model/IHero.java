package model;

import model.IDirection;
import model.IPosition;
import model.IObjective;

public interface IHero {

	public IObjective getObjective();
	public void move(IDirection direction) throws Exception;
	public void move(IPosition position);
	
}
