package model;

import java.util.HashMap;
import java.util.Map;

public class Tray {
	private Boundary boundary;
	private Level level;
	private Map<Position, Slab> slabs = new HashMap<Position, Slab>();
	private Map<Position, Character> charactersnew = new HashMap<Position, Character>();
	private Map<Position, Hero> heroes = new HashMap<Position, Hero>();
	private int id;
	
	public Tray(Level level, int id) throws Exception {
		this.level = level;
		this.id = id;
		
		boundary = new Boundary(this, new Delimitations(-2, 2, -2, 2));
		
		try {
			Position p = boundary.getMinPosition();
			Position pMax = boundary.getMaxPosition();
			
			while (!p.equals(pMax)) {
				addSlab(new Slab(level.getBlocks().get("Rock"), new Position(p)));
				
				p.next();
			}
			
			addSlab(new Slab(level.getBlocks().get("Rock"), new Position(p)));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	private void addSlab(Slab slab) {
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
