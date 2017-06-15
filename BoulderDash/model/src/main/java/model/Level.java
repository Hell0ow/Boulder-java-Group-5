package model;

import java.util.HashMap;
import java.util.Map;

public class Level {
	private Map<String, Block> blocks = new HashMap<String, Block>();
	private Game game;
	private Tray tray;
	
	public Level(Game game) throws Exception {
		this.game = game;
		
		addBlock(new Rock());
		
		tray = new Tray(this, 0);
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
