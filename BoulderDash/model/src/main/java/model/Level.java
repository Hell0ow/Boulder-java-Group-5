package model;

import java.util.HashMap;
import java.util.Map;

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
			
			//TEMP
		
			tray = new Tray(this, 0);

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
