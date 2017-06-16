package model;

public class Hero extends Character {
	private Objective objective;
	
	public Hero(Objective objective, Position position) {
		super(position);
		this.objective = objective;
		
		objective.setHero(this);
	}
	
	public Objective getObjective() {
		return objective;
	}
}
