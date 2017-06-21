package model;

import java.util.HashMap;
import java.util.Map;

public class Tray {
	private Boundary boundary;
	private Level level;
	private Integer id;

	private Map<Position, Being> beings = new HashMap<Position, Being>();
	private Map<Position, Enemy> enemies = new HashMap<Position, Enemy>();
	private Map<Integer, Hero> heroes = new HashMap<Integer, Hero>();
	private Map<Position, Tile> tiles = new HashMap<Position, Tile>();
	
	public Tray(Level level, Integer id) throws Exception {
		this.level = level;
		this.id = id;
		
		//TEMP
		
		boundary = new Boundary(this, 0, 4, 0, 4);
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.put(enemy.getPosition(), enemy);
		beings.put(enemy.getPosition(), enemy);
	}
	
	public void removeEnemy(Position position) {
		enemies.remove(position);
		beings.remove(position);
	}
	
	public Map<Position, Enemy> getEnemies() {
		return enemies;
	}
	
	public void addHero(Hero hero) {
		heroes.put(hero.getObjective().getPlayer().getId(), hero);
		beings.put(hero.getPosition(), hero);
	}
	
	public void removeHero(Position position) {
		heroes.remove(position);
		beings.remove(position);
	}
	
	public Map<Integer, Hero> getHeroes() {
		return heroes;
	}
	
	public void addTile(Tile tile) {
		tiles.put(tile.getPosition(), tile);
	}
	
	public void removeTile(Position position) {
		tiles.remove(position);
	}
	
	public Map<Position, Tile> getTiles() {
		return tiles;
	}
	
	public Map<Position, Being> getBeings() {
		return beings;
	}
	
	public Boundary getBoundary() {
		return new Boundary(boundary);
	}
	
	public void setBoundary(Boundary boundary) throws Exception {
		if (tiles.size() != 0 || beings.size() != 0) {
			throw new Exception();
		}
		
		this.boundary = boundary;
	}
	
	public Level getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}
}
