package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Block;
import model.Character;
import model.Direction;
import model.Dummy;
import model.Human;
import model.Model;
import model.Player;

public abstract class ControllerDAO {

		protected static void loadPlayer(ControllerDB database, String playerName, Model actualModel){

			Integer idPlayer = 0;
			
			try {
				database.addPlayer(playerName);
				ResultSet result = database.initPlayer(playerName);
				
				while(result.next()){
					idPlayer = result.getInt("ID_player");
				}
				
				Player actualPlayer = Factory.createPlayer(idPlayer, playerName);
				actualModel.setPlayer(actualPlayer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		protected static void loadEntity(ControllerDB database, Model actualModel) throws Exception{
			Character entityType = Factory.createHuman();
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
	    	actualModel.getLevel().addCharacter(entityType);
	    	
		}
	    
		
		
		protected static void loadBlock(ControllerDB database, Model actualModel) throws Exception{
			Block textureType = Factory.createAir();
	    	int getID = 0;
	    	ResultSet result = database.getExistingBlockTexture();
	    	
	    	while(result.next()){
	    		getID = result.getInt("ID_typeBlock");
	    		switch(getID){
	    		case 1:
	    			textureType = Factory.createDiamond();
	    			break;
	    		case 2:
	    			textureType = Factory.createRock();
	    			break;
	    		case 3:
	    			textureType = Factory.createMud();
	    			break;
	    		case 4:
	    			textureType = Factory.createWall();
	    			break;
	    		case 5:
	    			textureType = Factory.createAir();
	    			break;
	    		}
	    	}
	    	actualModel.getLevel().addBlock(textureType);	
		}
		
		
		protected static void loadSelectedMap(ControllerDB database, int mapID, Model actualModel) throws Exception{
			
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
			actualModel.getLevel().getTray().setBoundary(Factory.createBoundary(actualModel.getLevel().getTray(), X_min, X_max, Y_min, Y_max));

	    	
	    	//Add block for the selected map.
	    	result = database.getBlock(mapID);
	    	while(result.next()){
	    		X = result.getInt("X_block");
	    		Y = result.getInt("Y_block");
	    		texture = result.getString("Name_block");
	    		actualModel.getLevel().getTray().addTile(Factory.createTile(actualModel.getLevel().getBlocks().get(texture), Factory.createPosition(actualModel.getLevel().getTray(), X, Y)));
	    	}
	    	
	    	
	    	//Add entity for the selected map.
	    	result = database.getEntity(mapID);
	    	while(result.next()){
	    		X = result.getInt("X_entity");
	    		Y = result.getInt("Y_entity");
	    		entity = result.getString("Name_entity");
	    		switch(entity){
	    		case "Human":
	    			actualModel.getLevel().getTray().addHero(Factory.createHero((Human) actualModel.getLevel().getCharacters().get(entity), actualModel.getLevel().getObjective(), Factory.createPosition(actualModel.getLevel().getTray(), X, Y)));
	    			break;
	    		default:	
	    			actualModel.getLevel().getTray().addEnemy(Factory.createEnemy((Dummy) actualModel.getLevel().getCharacters().get(entity), Direction.UP, Factory.createPosition(actualModel.getLevel().getTray(), X, Y)));
	    		}
	    	}
		}
}
