package model;

import java.util.HashMap;
import java.util.Map;

import contract.Direction;

public class Level implements ILevel {
	private Map<String, IBlock> blocks = new HashMap<String, Block>();
	private Map<String, ICharacter> characters = new HashMap<String, Character>();
	
	private Model model;
	private Objective objective;
	private Tray tray;
	
	public Level(Model model) throws Exception {
		this.model = model;

		tray = new Tray(this, 0);
	}
	
	public Map<String, IBlock> getBlocks() {
		return blocks;
	}
	
	public void addBlock(Block block) {
		blocks.put(block.getName(), block);
	}
	
	public Map<String, ICharacter> getCharacters() {
		return characters;
	}
	
	public void addCharacter(Character character) {
		characters.put(character.getName(), character);
	}
	
	public IObjective getObjective() {
		return objective;
	}
	
	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	
	public ITray getTray() {
		return tray;
	}
}
