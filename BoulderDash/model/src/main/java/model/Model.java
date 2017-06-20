package model;

public class Model {
	private Level level;
	
	private Player player;
	
	public Model() throws Exception {
		
		player = new Player(0, "Antoine");
		
		level = new Level(this);
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
