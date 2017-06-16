package model;

import java.util.HashMap;
import java.util.Map;

public class Level {
	private Map<String, Block> blocks = new HashMap<String, Block>();
	private Game game;
	private Tray tray;
	
	public Level(Game game) throws Exception {
		this.game = game;

		addBlock(new Air());
		addBlock(new Diamond());
		addBlock(new Rock());
		addBlock(new Stone());
		addBlock(new Wall());
		
		try {
		
			tray = new Tray(this, 0, new Delimitations(0, 4, 0, 4));
		
			Position p = tray.getBoundary().getMinPosition();
			
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Diamond"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Stone"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Stone"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Wall"), new Position(p)));
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public Map<String, Block> getBlocks() {
		return blocks;
	}
	
	private void addBlock(Block block) {
		blocks.put(block.getName(), block);
	}
	
	public Tray getTray() {
		return tray;
	}
}
