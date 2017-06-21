package model;

import contract.Direction;

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
	
	@Override
	public void move(Direction direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	@Override
	public void move(Position position) {
		
		position.getTray().getTiles().get(position).dig();
		
		if (!position.getTray().getTiles().get(position).getBlock().isDense() && position.getTray().getBeings().get(position) == null) {
			
			this.position.getTray().removeEnemy(this.position);
			this.position.copy(position);
			position.getTray().addHero(this);
		}
	}
}
