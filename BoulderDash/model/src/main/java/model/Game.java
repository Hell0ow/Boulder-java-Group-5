package model;

import java.util.HashMap;
import java.util.Map;

public class Game {
	private Level level;
	private Map<Integer, Player> players = new HashMap<Integer, Player>();
	
	public Game() {
		try {
			addPlayer(new Player(0, "Nicolas Bigoune"));
			
			level = new Level(this);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Map<Integer, Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(Player player) {
		players.put(new Integer(player.getId()), player);
	}
}
