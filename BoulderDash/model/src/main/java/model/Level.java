package model;

import java.util.HashMap;
import java.util.Map;

public class Level {
	private Map<String, Block> blocks = new HashMap<String, Block>();
	private Map<String, Dummy> dummies = new HashMap<String, Dummy>();
	private Map<String, Human> humans = new HashMap<String, Human>();
	
	private Game game;
	private Objective objective;
	private Tray tray;
	
	public Level(Game game) throws Exception {
		this.game = game;
		
		objective = new Objective(game.getPlayer(), 25);

		addBlock(new Air());
		addBlock(new Diamond());
		addBlock(new Mud());
		addBlock(new Rock());
		addBlock(new Wall());
		
		addDummy(new Dummy());
		
		addHuman(new Human());
		
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
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Diamond"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addSlab(new Slab(blocks.get("Mud"), new Position(p)));	
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

			tray.addHero(new Hero(humans.get("Human"), objective, new Position(tray, 2, 2)));
			
			tray.addEnemy(new Enemy(dummies.get("Dummy"), new Position(tray, 4, 1)));
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	private void addBlock(Block block) {
		blocks.put(block.getName(), block);
	}
	
	private void addDummy(Dummy dummy) {
		dummies.put(dummy.getName(), dummy);
	}
	
	private void addHuman(Human human) {
		humans.put(human.getName(), human);
	}
	
	private Objective getObjective() {
		return objective;
	}
	
	public Tray getTray() {
		return tray;
	}
}
