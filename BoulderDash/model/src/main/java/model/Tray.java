package model;

import java.util.HashMap;
import java.util.Map;

import Imodel.IBeing;
import Imodel.IBoundary;
import Imodel.IEnemy;
import Imodel.IHero;
import Imodel.IPosition;
import Imodel.ITile;
import Imodel.ITray;

public class Tray implements ITray {
	
	private Boundary boundary;
	private Level level;
	private Integer id;

	private Map<IPosition, IBeing> beings = new HashMap<IPosition, IBeing>();
	private Map<IPosition, IEnemy> enemies = new HashMap<IPosition, IEnemy>();
	private Map<Integer, IHero> heroes = new HashMap<Integer, IHero>();
	private Map<IPosition, ITile> tiles = new HashMap<IPosition, ITile>();
	
	public Tray(Level level, Integer id) throws Exception {
		
		this.level = level;
		this.id = id;
		
		boundary = new Boundary(this, 0, 4, 0, 4);
	}
	
	public void addEnemy(IEnemy enemy) {
		enemies.put(enemy.getPosition(), enemy);
		beings.put(enemy.getPosition(), enemy);
	}
	
	public void removeEnemy(IPosition position) {
		enemies.remove(position);
		beings.remove(position);
	}
	
	public Map<IPosition, IEnemy> getEnemies() {
		return enemies;
	}
	
	public void addHero(IHero hero) {
		heroes.put(hero.getObjective().getPlayer().getId(), hero);
		beings.put(hero.getPosition(), hero);
	}
	
	public void removeHero(IPosition position) {
		heroes.remove(position);
		beings.remove(position);
	}
	
	public Map<Integer, IHero> getHeroes() {
		return heroes;
	}
	
	public void addTile(ITile tile) {
		tiles.put(tile.getPosition(), tile);
	}
	
	public void removeTile(IPosition position) {
		tiles.remove(position);
	}
	
	public Map<IPosition, ITile> getTiles() {
		return tiles;
	}
	
	public Map<IPosition, IBeing> getBeings() {
		return beings;
	}
	
	public Boundary getBoundary() {
		return new Boundary(boundary);
	}
	
	public void setBoundary(IBoundary boundary) throws Exception {
		
		if (tiles.size() != 0 || beings.size() != 0) {
			throw new Exception();
		}
		
		this.boundary = (Boundary) boundary;
	}
	
	public Level getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}
}
