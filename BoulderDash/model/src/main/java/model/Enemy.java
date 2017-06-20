package model;

public class Enemy extends Being {
	private Direction direction;
	
	public Enemy(Dummy dummy, Direction direction, Position position) {
		super(dummy, position);
		
		this.direction = direction;
	}
	
	public Dummy getDummy() {
		return (Dummy) element;
	}
	
	public Direction move() throws Exception {
		
		int i = 0;
		
		while (!position.getTray().getTiles().get(new Position(position).addition(direction)).getBlock().isDense() && i < 4) {
			
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
}
