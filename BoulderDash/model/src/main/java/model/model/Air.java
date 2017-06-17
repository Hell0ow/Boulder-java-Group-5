package model;

public class Air extends Block {
	public Air() {
		super("Air", 'A');
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
