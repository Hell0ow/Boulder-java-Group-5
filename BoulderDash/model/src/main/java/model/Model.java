package model;

import java.util.ArrayList;

import Imodel.IOrder;
import Imodel.IPlayer;
import Imodel.IEnemy;
import Imodel.ILevel;
import Imodel.IModel;
import Imodel.IPosition;
import Imodel.ITile;

public class Model implements IModel {

	private Level level;
	private Player player;
	
	public Model() throws Exception {
		
		level = new Level(this);
	}
	
	public ILevel getLevel() {
		return (ILevel) level;
	}
	
	public IPlayer getPlayer() {
		return (IPlayer) player;
	}
	
	public void setPlayer(IPlayer player) {
		this.player = (Player) player;
	}
	
	public void cycle(IOrder order) throws Exception {
		
		switch((Order) order) {
			
			case MOVE_UP:
				
				level.getTray().getHeroes().get(player.getId()).move((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.UP));
				
				break;
			
			case MOVE_RIGHT:
				
				level.getTray().getHeroes().get(player.getId()).move((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.RIGHT));	
				
				break;
			
			case MOVE_DOWN:
				
				level.getTray().getHeroes().get(player.getId()).move((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.DOWN));
				
				break;
			
			case MOVE_LEFT:
				
				level.getTray().getHeroes().get(player.getId()).move((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.LEFT));
				
				break;
			
			case DIG_UP:
				
				level.getTray().getTiles().get((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.UP)).dig();
				
				break;
			
			case DIG_RIGHT:
				
				level.getTray().getTiles().get((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.RIGHT)).dig();
				
				break;
			
			case DIG_DOWN:
				
				level.getTray().getTiles().get((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.DOWN)).dig();
				
				break;
			
			case DIG_LEFT:
				
				level.getTray().getTiles().get((IPosition) new Position((Position) level.getTray().getHeroes().get(player.getId()).getPosition()).addition(Direction.LEFT)).dig();
				
				break;
			
			default:
				break;
		}
		
		for (ITile tile : new ArrayList<ITile>(level.getTray().getTiles().values())) {
			if (tile.getBlock().isFallable()) {
				tile.fall();
			}
		}
		
		for (IEnemy enemy : level.getTray().getEnemies().values()) {
			enemy.move();
		}
	}
}
