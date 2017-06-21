package model;

import Imodel.IDirection;
import Imodel.IDummy;
import Imodel.IEnemy;
import Imodel.IPosition;

public class Enemy extends Being implements IEnemy {
	
	private Direction direction;
	
	public Enemy(Dummy dummy, Direction direction, Position position) {
		super(dummy, position);
		
		this.direction = direction;
	}
	
	public IDummy getDummy() {
		return (IDummy) element;
	}
	
	private IDirection intelligence() throws Exception {
		
		int i = 0;
		
		while ((position.getTray().getTiles().get(new Position(position).addition(direction)).getBlock().isDense() || position.getTray().getBeings().get(new Position(position).addition(direction)) != null) && i < 4) {
			
			switch (direction) {
			
				case UP:
					direction = Direction.RIGHT;
					break;
				case RIGHT:
					direction = Direction.DOWN;
					break;
				case DOWN:
					direction = Direction.LEFT;
					break;
				case LEFT:
					direction = Direction.UP;
					break;
			}
			
			i++;
		}
		
		return (IDirection) direction;
	}
	
	public void move() throws Exception {
		move(intelligence());
	}
	
	@Override
	public void move(IDirection direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	@Override
	public void move(IPosition position) {
		
		if (!position.getTray().getTiles().get((IPosition) position).getBlock().isDense() && position.getTray().getBeings().get((IPosition) position) == null) {
			
			this.position.getTray().removeEnemy((IPosition) this.position);
			this.position.copy((IPosition) position);
			position.getTray().addEnemy((IEnemy) this);
		}
	}

}
