package model;

public class Tile extends Entity {
	public Tile(Block block, Position position) {
		super(block, position);
	}
	
	public Block getBlock() {
		return (Block) element;
	}
}
