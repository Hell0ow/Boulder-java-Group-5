package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Direction;
import modelContract.IBlock;
import modelContract.IBoundary;
import modelContract.ICharacter;
import modelContract.IDirection;
import modelContract.IDummy;
import modelContract.IEnemy;
import modelContract.IHero;
import modelContract.IHuman;
import modelContract.IModel;
import modelContract.IPlayer;
import modelContract.ITray;


public abstract class ControllerDAO {

		protected static void loadPlayer(ControllerDB database, String playerName, IModel iModel){

			Integer idPlayer = 0;
			
			try {
				database.addPlayer(playerName);
				ResultSet result = database.initPlayer(playerName);
				
				while(result.next()){
					idPlayer = result.getInt("ID_player");
				}
				
				IPlayer actualPlayer = Factory.createPlayer(idPlayer, playerName);
				iModel.setPlayer(actualPlayer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		protected static void loadEntity(ControllerDB database, IModel iModel) throws Exception{
			ICharacter entityType = Factory.createHuman();
	    	int getID = 0;
	    	ResultSet result = database.getExistingEntity();
	    	
	    	while(result.next()){
	    		getID = result.getInt("ID_typeEntity");
	    		switch(getID){
	    		case 1:
	    			entityType = Factory.createHuman();
	    			break;
	    		case 2:
	    			entityType = Factory.createDummy();
	    			break;
	    		case 3:
	    			entityType = Factory.createDummy();
	    			break;
	    		case 4:
	    			entityType = Factory.createDummy();
	    			break;
	    		case 5:
	    			entityType = Factory.createDummy();
	    			break;
	    		case 6:
	    			entityType = Factory.createDummy();
	    			break;
	    		case 7:
	    			entityType = Factory.createDummy();
	    			break;
	    		default:
	    		}
	    			
	    	}
	    	iModel.getLevel().addCharacter((ICharacter) entityType);
	    	
		}
	    
		
		
		protected static void loadBlock(ControllerDB database, IModel iModel) throws Exception{
			IBlock textureType = (IBlock) Factory.createAir();
	    	int getID = 0;
	    	ResultSet result = database.getExistingBlockTexture();
	    	
	    	while(result.next()){
	    		getID = result.getInt("ID_typeBlock");
	    		switch(getID){
	    		case 1:
	    			textureType = (IBlock) Factory.createDiamond();
	    			break;
	    		case 2:
	    			textureType = (IBlock) Factory.createRock();
	    			break;
	    		case 3:
	    			textureType = (IBlock) Factory.createMud();
	    			break;
	    		case 4:
	    			textureType = (IBlock) Factory.createWall();
	    			break;
	    		case 5:
	    			textureType = (IBlock) Factory.createAir();
	    			break;
	    		}
	    	}
	    	iModel.getLevel().addBlock((IBlock) textureType);	
		}
		
		
		protected static void loadSelectedMap(ControllerDB database, int mapID, IModel iModel) throws Exception{
			
			int X_max = 0, X_min = 0, Y_max = 0, Y_min = 0, X = 0, Y = 0;
	    	String texture = Factory.createString(), entity = Factory.createString();
	    	
	    	
	    	//Add map size for the selected map.
	    	ResultSet result = database.getBoundary(mapID);
	    	while(result.next()){
	    		X_min = result.getInt("Xmin_map");
	    		X_max = result.getInt("Xmax_map");
	    		Y_max = result.getInt("Ymax_map");
	    		Y_min = result.getInt("Ymin_map");
	    	}
			iModel.getLevel().getTray().setBoundary((IBoundary) Factory.createBoundary((ITray) iModel.getLevel().getTray(), X_min, X_max, Y_min, Y_max));

	    	
	    	//Add block for the selected map.
	    	result = database.getBlock(mapID);
	    	while(result.next()){
	    		X = result.getInt("X_block");
	    		Y = result.getInt("Y_block");
	    		texture = result.getString("Name_block");
	    		iModel.getLevel().getTray().addTile(Factory.createTile(iModel.getLevel().getBlocks().get(texture), Factory.createPosition(iModel.getLevel().getTray(), X, Y)));
	    	}
	    	
	    	
	    	//Add entity for the selected map.
	    	result = database.getEntity(mapID);
	    	while(result.next()){
	    		X = result.getInt("X_entity");
	    		Y = result.getInt("Y_entity");
	    		entity = result.getString("Name_entity");
	    		switch(entity){
	    		case "Human":
	    			iModel.getLevel().getTray().addHero((IHero) Factory.createHero((IHuman) iModel.getLevel().getCharacters().get(entity), iModel.getLevel().getObjective(), Factory.createPosition(iModel.getLevel().getTray(), X, Y)));
	    			break;
	    		default:	
	    			iModel.getLevel().getTray().addEnemy((IEnemy) Factory.createEnemy((IDummy) iModel.getLevel().getCharacters().get(entity), Direction.UP, Factory.createPosition(iModel.getLevel().getTray(), X, Y)));
	    		}
	    	}
		}
}
