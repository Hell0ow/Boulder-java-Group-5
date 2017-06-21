package model;

import modelContract.IBlock;
import modelContract.IPosition;
import modelContract.ITile;

public class Tile extends Entity implements ITile {
	
	public Tile(IBlock block, IPosition position) {
		super(block, position);
	}
	
	public IBlock getBlock() {
		return (IBlock) element;
	}
	
	public boolean dig() {
		
		if (getBlock().isDiggeable()) {
			
			position.getTray().removeTile(position);
			position.getTray().addTile(new Tile(position.getTray().getLevel().getBlocks().get("Air"), position));
			
			return true;
		}
		
		return false;
	}
	
	public boolean fall() throws Exception {

		if (!position.getTray().getTiles().get(new Position(position).addition(Direction.DOWN)).getBlock().isDense()) {
			
			position.getTray().removeTile(new Position(position).addition(Direction.DOWN));
			position.getTray().removeTile(position);
			position.getTray().addTile(new Tile(position.getTray().getLevel().getBlocks().get("Air"), new Position(position)));
			position.addition(Direction.DOWN);
			position.getTray().addTile(this);
			
		}
		
		return true;
	}
}
