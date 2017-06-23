package model;

import Imodel.IHero;
import Imodel.IObjective;
import Imodel.IPlayer;

public class Objective implements IObjective {
	private Hero hero = null;
	private Player player;
	private int obtained = 0;
	private int required;
	
	public Objective(Player player, int required) {
		this.player = player;
		this.required = required;
	}
	
	public Objective(Objective objective) {
		required = objective.required;
		obtained = objective.obtained;
	}
	
	public boolean isCompleted() {
		return obtained >= required;
	}
	
	public IHero getHero() {
		return (IHero) hero;
	}
	
	public void setHero(IHero hero) {
		this.hero = (Hero) hero;
	}
	
	public IPlayer getPlayer() {
		return (IPlayer) player;
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
