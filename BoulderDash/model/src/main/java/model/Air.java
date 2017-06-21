package model;

public class Air extends Block {
	
	public Air() throws Exception {
		super("Air", ' ', "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(32, 0));
	}
	
	@Override
	public boolean isBreakable() {
		return false;
	}
	
	@Override
	public boolean isDense() {
		return false;
	}
}
