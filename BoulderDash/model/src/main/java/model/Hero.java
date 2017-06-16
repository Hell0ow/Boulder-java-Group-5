package model;

public class Hero extends Being {
	private Objective objective;
	
	public Hero(Character character, Objective objective, Position position) {
		super(character, position);
		this.objective = objective;
		
		objective.setHero(this);
	}
	
	public Objective getObjective() {
		return objective;
	}
}
