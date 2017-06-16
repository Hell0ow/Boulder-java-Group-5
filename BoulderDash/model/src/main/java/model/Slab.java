package model;

public class Slab extends Entity {
	
	Slab(Block block, Position position) {
		super(block, position);
	}
	
	public Block getBlock() {
		return (Block) element;
	}
}
