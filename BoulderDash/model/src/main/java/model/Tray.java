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
	private Map<Position, Slab> slabs = new HashMap<Position, Slab>();
	
	public Tray(Level level, Integer id, Delimitations delimitations) throws Exception {
		this.level = level;
		this.id = id;
		boundary = new Boundary(this, delimitations);
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.put(enemy.getPosition(), enemy);
		beings.put(enemy.getPosition(), enemy);
	}
	
	public Map<Position, Enemy> getEnemies() {
		return enemies;
	}
	
	public void addHero(Hero hero) {
		heroes.put(hero.getObjective().getPlayer().getId(), hero);
		beings.put(hero.getPosition(), hero);
	}
	
	public Map<Integer, Hero> getHeroes() {
		return heroes;
	}
	
	public void addSlab(Slab slab) {
		slabs.put(slab.getPosition(), slab);
	}
	
	public Map<Position, Slab> getSlabs() {
		return slabs;
	}
	
	public void addBeing(Being being) {
		beings.put(being.getPosition(), being);
	}
	
	public Map<Position, Being> getBeings() {
		return beings;
	}
	
	public Boundary getBoundary() {
		return new Boundary(boundary);
	}

	public int getId() {
		return id;
	}
}
