package model;

public class Rock extends Block {
	
	public Rock() throws Exception {
		super("Rock", 'R', "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(48, 0));
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
	
	@Override
	public boolean isSmooth() {
		return true;
	}
}
