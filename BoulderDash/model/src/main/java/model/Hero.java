package model;

import Imodel.IDirection;
import Imodel.IHero;
import Imodel.IObjective;
import Imodel.IPosition;

public class Hero extends Being implements IHero {
	
	private Objective objective;
	
	public Hero(Character character, Objective objective, Position position) {
		super(character, position);
		this.objective = objective;
		
		objective.setHero((IHero) this);
	}
	
	public IObjective getObjective() {
		return (IObjective) objective;
	}
	
	@Override
	public void destroy() {
		
		position.getTray().getLevel().getModel().finish();
	}
	
	@Override
	public void move(IDirection direction) throws Exception {
		move(new Position(position).addition(direction));
	}
	
	@Override
	public void move(IPosition position) {
		
		position.getTray().getTiles().get((IPosition) position).dig();
		
		if (!position.getTray().getTiles().get(position).getBlock().isDense() && position.getTray().getBeings().get(position) == null) {
			
			this.position.getTray().removeEnemy((IPosition) this.position);
			this.position.copy(position);
			position.getTray().setHero((IHero) this);
		}
	}
}
