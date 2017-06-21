package model;

import java.util.Map;

public interface ITray {
	
	public void addEnemy(IEnemy enemy);
	
	public void removeEnemy(IPosition position);
	
	public Map<IPosition, IEnemy> getEnemies();
	
	public void addHero(IHero hero);
	
	public void removeHero(IPosition position);
	
	public Map<Integer, IHero> getHeroes();
	
	public void addTile(ITile tile);
	
	public void removeTile(IPosition position);
	
	public Map<IPosition, ITile> getTiles();
	
	public Map<IPosition, IBeing> getBeings();
	
	public IBoundary getBoundary();
	
	public void setBoundary(IBoundary boundary);
	
	public ILevel getLevel();

	public int getId();
}
