package model;

import Imodel.IBeing;
import Imodel.ICharacter;

public abstract class Being extends Entity implements IBeing {
	
	protected Being(Character character, Position position) {
		super(character, position);
	}
	
	public ICharacter getCharacter() {
		return (ICharacter) element;
	}
	
	public void destroy() {}
	
	@Override
	public void explode() throws Exception {
		
		destroy();
		
		Position p = new Position(position);
		
		if (position.getTray().getBeings().get(p.addition(Direction.UP)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		
		if (position.getTray().getBeings().get(p.addition(Direction.RIGHT)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		
		if (position.getTray().getBeings().get(p.addition(Direction.DOWN)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		
		if (position.getTray().getBeings().get(p.addition(Direction.DOWN)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		
		if (position.getTray().getBeings().get(p.addition(Direction.LEFT)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		if (position.getTray().getBeings().get(p.addition(Direction.LEFT)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		if (position.getTray().getBeings().get(p.addition(Direction.UP)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		if (position.getTray().getBeings().get(p.addition(Direction.UP)) != null) {
			position.getTray().getBeings().get(p).destroy();
		}
		
		position.getTray().getTiles().get(p.addition(Direction.UP)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.RIGHT)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.DOWN)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.DOWN)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.LEFT)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.LEFT)).destroy();
		position.getTray().getTiles().get(p.addition(Direction.UP)).destroy();
	}
	
	public void move(Direction direction) throws Exception {
		move(new Position((Position) position).addition(direction));
	}
	
	public void move(Position position) {}
}
