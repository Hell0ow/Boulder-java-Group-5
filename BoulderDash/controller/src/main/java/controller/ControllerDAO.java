package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Imodel.*;
import model.Block;
import model.Direction;
import model.Dummy;
import model.Enemy;
import model.Position;
import model.Tray;


/**
 * <b> ControllerDAO have to transform, load, use and send all result which are from ControllerDB.</b>
 * <p> This class transform each result to stock them in model part. </p>
 * 
 * @author Antoine Savalle
 * @version 2.0
 * @see Controller#initGame()
 */
public abstract class ControllerDAO {
	
	
	/**
	 * <p> This method receive map name from SQL request and send them as List</p>
	 * @param database ControllerDB
	 * @return listmap List
	 * @throws SQLException
	 * @see {@link Controller#Game()}
	 */
	protected static List<String> getAllMapName(ControllerDB database) throws SQLException{
		String mapName = new String(); 
		List <String> listMap = new ArrayList<String>();
		
		ResultSet result = database.getAllMapName();
		while(result.next()){
			mapName = result.getString("Name_map");
			listMap.add(mapName);
		}
		return listMap;
	}
	
	
		/**
		 * <p> This method have to receive a map ID with a map name and send it as int.</p>
		 * @param database ControllerDB
		 * @param mapName String
		 * @return mapID int
		 * @throws SQLException
		 * @see {@link Controller#Game()}
		 */
		public static int getIDmap(ControllerDB database, String mapName) throws SQLException{
			int mapID = 0; 
			
			ResultSet result = database.getIDmap(mapName);
			while(result.next()){
				mapID = result.getInt("ID_map");
			}
			return mapID;
		}
		
		
		/**
		 * <p> This method have to create a new player in the model with a player name.</p>
		 * @param database ControllerDB
		 * @param playerName String
		 * @throws SQLException
		 * @see {@link Controller#Game()}
		 */
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
		
		
		/**
		 * <p> This method have to take all existing entity and load them in model as Human or Dummy type.</p>
		 * @param database ControllerDB
		 * @param iModel IModel
		 * @throws SQLException
		 * @see {@link Controller#Game()}
		 */
		protected static void loadEntity(ControllerDB database, IModel iModel) throws Exception{
			ICharacter entityType = (ICharacter) Factory.createHuman();
	    	int getID = 0;
	    	ResultSet result = database.getExistingEntity();
	    	
	    	while(result.next()){
	    		getID = result.getInt("ID_typeEntity");
	    		switch(getID){
	    		case 1:
	    			entityType = (ICharacter) Factory.createHuman();
	    			break;
	    		case 2:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		case 3:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		case 4:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		case 5:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		case 6:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		case 7:
	    			entityType = (ICharacter) Factory.createDummy();
	    			break;
	    		default:
	    		}
	    		iModel.getLevel().addCharacter((ICharacter) entityType);
	    	}
	    	
	    	
		}
	    
		
		/**
		 * <p> This method have to receive a map ID with a map name and send it as int.</p>
		 * @param database ControllerDB
		 * @param mapName String
		 * @return mapID int
		 * @throws SQLException
		 * @see {@link Controller#Game()}
		 */
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
	    		iModel.getLevel().addBlock((IBlock) textureType);	
	    	}
	    	
		}
		
		/**
		 * <p> This method have to load boundary, load entity and load block in the actual model.</p>
		 * @param database ControllerDB
		 * @param mapID int
		 * @param iModel IModel
		 * @throws SQLException
		 * @see {@link Controller#Game()}
		 */
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
	    		iModel.getLevel().getTray().addTile(Factory.createTile((Block) iModel.getLevel().getBlocks().get(texture), (Position) Factory.createPosition((Tray) iModel.getLevel().getTray(), X, Y)));
	    	}
	    	
	    	
	    	//Add entity for the selected map.
	    	result = database.getEntity(mapID);
	    	while(result.next()){
	    		X = result.getInt("X_entity");
	    		Y = result.getInt("Y_entity");
	    		entity = result.getString("Name_entity");
	    		switch(entity){
	    		case "Human":
	    			iModel.getLevel().getTray().setHero((IHero) Factory.createHero((IHuman) iModel.getLevel().getCharacters().get(entity), iModel.getLevel().getObjective(), (IPosition) Factory.createPosition((Tray) iModel.getLevel().getTray(), X, Y)));
	    			break;
	    		default:
	    			iModel.getLevel().getTray().addEnemy((IEnemy) Factory.createEnemy((IDummy) iModel.getLevel().getCharacters().get("Dummy"), Direction.LEFT, (IPosition) Factory.createPosition((Tray) iModel.getLevel().getTray(), X, Y)));
	    		}
	    	}
		}
}
