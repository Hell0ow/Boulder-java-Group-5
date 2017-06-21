package model;

import java.util.HashMap;
import java.util.Map;

import contract.Direction;

public class Level {
	private Map<String, Block> blocks = new HashMap<String, Block>();
	private Map<String, Character> characters = new HashMap<String, Character>();
	
	private Model model;
	private Objective objective;
	private Tray tray;
	
	public Level(Model model) throws Exception {
		this.model = model;
		
		//TEMP
		
		setObjective(new Objective(model.getPlayer(), 25));

		addBlock(new Air());
		addBlock(new Diamond());
		addBlock(new Mud());
		addBlock(new Rock());
		addBlock(new Wall());
		
		addCharacter(new Dummy());
		
		addCharacter(new Human());
			
			//TEMP
		
			tray = new Tray(this, 0);
		
			Position p = tray.getBoundary().getMinPosition();
			
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Mud"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Rock"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Air"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));	
			p.next();
			tray.addTile(new Tile(blocks.get("Wall"), new Position(p)));
			
			tray.addHero(new Hero((Human) characters.get("Human"), objective, new Position(tray, 1, 3)));
			
			tray.addEnemy(new Enemy((Dummy) characters.get("Dummy"), Direction.UP, new Position(tray, 2, 2)));
	}
	
	public Map<String, Block> getBlocks() {
		return blocks;
	}
	
	public void addBlock(Block block) {
		blocks.put(block.getName(), block);
	}
	
	public Map<String, Character> getCharacters() {
		return characters;
	}
	
	public void addCharacter(Character character) {
		characters.put(character.getName(), character);
	}
	
	public Objective getObjective() {
		return objective;
	}
	
	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	
	public Tray getTray() {
		return tray;
	}
}
