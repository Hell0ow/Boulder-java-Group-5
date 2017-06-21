package model;

import Imodel.IBlock;
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

		if (!position.getTray().getTiles().get(new Position((Position) position).addition(Direction.DOWN)).getBlock().isDense()) {
			
			position.getTray().removeTile((IPosition) new Position((Position) position).addition(Direction.DOWN));
			position.getTray().removeTile((IPosition) position);
			position.getTray().addTile((ITile) new Tile((Block) position.getTray().getLevel().getBlocks().get("Air"), new Position((Position) position)));
			position.addition(Direction.DOWN);
			position.getTray().addTile(this);
		
			return true;
		}
		
		return false;
	}
}
