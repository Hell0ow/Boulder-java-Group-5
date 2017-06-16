package model;

public class Objective {
	private Hero hero = null;
	private Player player;
	private int obtained;
	private int required;
	
	public Objective(Player player, int required) {
		this.player = player;
		this.required = required;
		obtained = 0;
	}
	
	public Objective(Objective objective) {
		required = objective.required;
		obtained = objective.obtained;
	}
	
	public boolean isCompleted() {
		return obtained >= required;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getObtained() {
		return obtained; 
	}
	
	public void setObtained(int obtained) {
		this.obtained = obtained;
	}
	
	public int getRequired() {
		return required;
	}
}
