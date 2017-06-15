package model;

public class Hero extends Character {
	private Player player;
	
	public Hero(Player player, Position position) {
		super(position);
		this.player = player;
	}
}
