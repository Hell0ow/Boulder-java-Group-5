package model;

public class Mud extends Block {
	public Mud() {
		super("Mud", 'M');
	}
	
	@Override
	public boolean isDiggeable() {
		return true;
	}
}
