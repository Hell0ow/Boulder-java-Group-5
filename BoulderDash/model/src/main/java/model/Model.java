package model;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class Model implements IModel{
=======
import contract.Direction;
import contract.Order;

public class Model implements IModel {

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
	
	public void cycle(Order order) throws Exception {
		
		switch(order) {
			
			case MOVE_UP:
				
				level.getTray().getHeroes().get(player.getId()).move(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.UP));
				
				break;
			
			case MOVE_RIGHT:
				
				level.getTray().getHeroes().get(player.getId()).move(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.RIGHT));
					
				break;
			
			case MOVE_DOWN:
				
				level.getTray().getHeroes().get(player.getId()).move(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.DOWN));
				
				break;
			
			case MOVE_LEFT:
				
				level.getTray().getHeroes().get(player.getId()).move(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.LEFT));
				
				break;
			
			case DIG_UP:
				
				level.getTray().getTiles().get(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.UP)).dig();
				
				break;
			
			case DIG_RIGHT:
				
				level.getTray().getTiles().get(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.RIGHT)).dig();
				
				break;
			
			case DIG_DOWN:
				
				level.getTray().getTiles().get(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.DOWN)).dig();
				
				break;
			
			case DIG_LEFT:
				
				level.getTray().getTiles().get(new Position(level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.LEFT)).dig();
				
				break;
			
			default:
				break;
		}
		
		for (Tile tile : new ArrayList<Tile>(level.getTray().getTiles().values())) {
			if (tile.getBlock().isFallable()) {
				tile.fall();
			}
		}
		
		for (Enemy enemy : level.getTray().getEnemies().values()) {
			enemy.move();
		}
	}
}
