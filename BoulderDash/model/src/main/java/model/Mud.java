package model;

public class Mud extends Block {
	
	public Mud() throws Exception {
		super("Mud", 'M', "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(16, 0));
	}
	
	@Override
	public boolean isDiggeable() {
		return true;
	}
}
