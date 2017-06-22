package Imodel;

import java.util.Map;

public interface ITray {
	
	public void addEnemy(IEnemy enemy);
	
	public void removeEnemy(IPosition position);
	
	public Map<IPosition, IEnemy> getEnemies();
	
	public void setHero(IHero hero);
	
	public IHero getHero();
	
	public void addTile(ITile tile);
	
	public void removeTile(IPosition position);
	
	public Map<IPosition, ITile> getTiles();
	
	public Map<IPosition, IBeing> getBeings();
	
	public IBoundary getBoundary();
	
	public void setBoundary(IBoundary boundary) throws Exception;
	
	public ILevel getLevel();

	public int getId();
	
	public int countDepth(IPosition position) throws Exception;
}
