package model;

public class Slab extends Entity {
	private Block block;
	
	Slab(Block block, Position position) {
		super(position);
		
		this.block = block;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public void setBlock(Block block) {
		this.block = block;
	}
}
