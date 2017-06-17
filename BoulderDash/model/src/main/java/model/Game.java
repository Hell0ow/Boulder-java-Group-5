package model;

public class Game {
	private Level level;
	private Player player;
	
	public Game() {
		try {
			player = new Player(0, "Nicolas Bigoune");
			
			level = new Level(this);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Player getPlayer() {
		return player;
	}
}
