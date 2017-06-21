package model;

import Imodel.IHero;
import Imodel.IObjective;
import Imodel.IPosition;

public class Hero extends Being {
	
	private Objective objective;
	
	public Hero(Character character, Objective objective, Position position) {
		super(character, position);
		this.objective = objective;
		
		objective.setHero(this);
	}
	
	public IObjective getObjective() {
		return (IObjective) objective;
	}
	
	@Override
	public void move(Direction direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	@Override
	public void move(IPosition position) {
		
		position.getTray().getTiles().get((IPosition) position).dig();
		
		if (!position.getTray().getTiles().get(position).getBlock().isDense() && position.getTray().getBeings().get(position) == null) {
			
			this.position.getTray().removeEnemy((IPosition) this.position);
			this.position.copy(position);
			position.getTray().addHero((IHero) this);
		}
	}
}
