package model;

import contract.Direction;

public class Enemy extends Being {
	private Direction direction;
	
	public Enemy(Dummy dummy, Direction direction, Position position) {
		super(dummy, position);
		
		this.direction = direction;
	}
	
	public Dummy getDummy() {
		return (Dummy) element;
	}
	
	private Direction intelligence() throws Exception {
		
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
		
		return direction;
	}
	
	public void move() throws Exception {
		move(intelligence());
	}
	
	@Override
	public void move(Direction direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	@Override
	public void move(Position position) {
		
		if (!position.getTray().getTiles().get(position).getBlock().isDense() && position.getTray().getBeings().get(position) == null) {
			
			this.position.getTray().removeEnemy(this.position);
			this.position.copy(position);
			position.getTray().addEnemy(this);
		}
	}
}
