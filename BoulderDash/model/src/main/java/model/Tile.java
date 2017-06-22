package model;

import Imodel.IBlock;
import Imodel.IDirection;
import Imodel.IPosition;
import Imodel.ITile;

public class Tile extends Entity implements ITile {
	
	public Tile(Block block, Position position) {
		super(block, position);
	}
	
	public IBlock getBlock() {
		return (IBlock) element;
	}
	
	public boolean dig() {
		
		if (getBlock().isDiggeable()) {
			
			position.getTray().removeTile((IPosition) position);
			position.getTray().addTile(new Tile((Block) position.getTray().getLevel().getBlocks().get("Air"), position));
			
			return true;
		}
		
		return false;
	}

	public boolean fall() throws Exception {
		
		if (!position.getTray().getTiles().get(new Position(position).addition(Direction.DOWN)).getBlock().isDense()) {
			
			move(Direction.DOWN);
	
			return true;
			
		} else if (position.getTray().getTiles().get(new Position(position).addition(Direction.DOWN)).getBlock().isSmooth()) {
			
			int right = position.getTray().countDepth(new Position(position).addition(Direction.RIGHT));
			int left = position.getTray().countDepth(new Position(position).addition(Direction.LEFT));
			
			if (right >= 2 || left >= 2) {
				
				if (right >= left) {
					
					move(Direction.RIGHT);
					
				} else {
					
					move(Direction.LEFT);
				}
				
				return true;
			
			} else {
				
				return false;
			}
			
			
		
		} else {
			
			return false;
		
		}
	}
	
	private void move(IDirection direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	private void move(IPosition position) throws Exception {
		
		position.getTray().removeTile(position);
		this.position.getTray().removeTile(this.position);
		this.position.getTray().addTile((ITile) new Tile((Block) position.getTray().getLevel().getBlocks().get("Air"), this.position));
		this.position = (Position) position;
		position.getTray().addTile(this);
	}
}
