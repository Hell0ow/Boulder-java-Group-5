package model;

import java.util.HashMap;
import java.util.Map;

public class Tray {
	private Boundary boundary;
	private Level level;
	private Integer id;

	private Map<Position, Slab> slabs = new HashMap<Position, Slab>();
	private Map<Position, Character> characters = new HashMap<Position, Character>();
	private Map<Position, Hero> heroes = new HashMap<Position, Hero>();
	
	public Tray(Level level, Integer id, Delimitations delimitations) throws Exception {
		this.level = level;
		this.id = id;
		boundary = new Boundary(this, delimitations);
	}
	
	public void addSlab(Slab slab) {
		slabs.put(slab.getPosition(), slab);
	}
	
	public Slab getSlab(Position position) {
		return slabs.get(position);
	}
	
	public Map<Position, Slab> getSlabs() {
		return slabs;
	}
	
	public Boundary getBoundary() {
		return new Boundary(boundary);
	}

	public int getId() {
		return id;
	}
}
