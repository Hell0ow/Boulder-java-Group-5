package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Block;
import model.Character;
import model.Direction;
import model.Dummy;
import model.Human;
import model.Model;
import model.Player;



public class ControllerInit {

	private String user     = "java";
	private String password = "bigouneroot";
    private String url      = "jdbc:mysql://164.132.49.33:3306/boulderdash?useSSL=false&serverTimezone=UTC";
    private Connection connection = null;
    private Statement  statement;
    
    
    
    
    
    
    public ControllerInit(String user, String password){
		this.user = user;
		this.password = password;
		
		try{
			connection = DriverManager.getConnection(this.url, this.user, this.password);
			statement = connection.createStatement();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
    
    
    
    
    
    
    
    public void addPlayer(String playerName) throws SQLException{
    	
    	statement.executeUpdate("CALL addPlayer('" + playerName + "');");
    }
    
    
    
    
    
    
    
    
    
    public void initPlayer(Model actualModel, String playerName) throws SQLException{
    	
    	ResultSet result = statement.executeQuery("CALL initPlayer('" + playerName + "');");
    	
    	Integer idPlayer = 0;
		
		while(result.next()){
			idPlayer = result.getInt("ID_player");
		}
		
		Player actualPlayer = Factory.createPlayer(idPlayer, playerName);
		actualModel.setPlayer(actualPlayer);
    }
    
    
    
    
    
    
    
    public void getExistingBlockTexture(Model actualModel) throws SQLException{
    	
    	Block textureType = Factory.createAir();
    	int getID = 0;
    	ResultSet result = statement.executeQuery("CALL getBlockTexture();");
    	
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
    		actualModel.getLevel().addBlock(textureType);	
    	}
    }
    
    
    
    
    
	public void getExistingEntity(Model actualModel) throws SQLException{
	    	
	    	Character entityType = Factory.createHuman();
	    	int getID = 0;
	    	ResultSet result = statement.executeQuery("CALL getAllEntityName();");
	    	
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
	    		actualModel.getLevel().addCharacter(entityType);	
	    	}
	   }
    
    
    
    public void getBoundary (Model actualModel, int mapID) throws SQLException{
    	
    	int X_max = 0, X_min = 0, Y_max = 0, Y_min = 0;
    	
    	ResultSet result = statement.executeQuery("CALL getBoundary('" + mapID + "');");
    	
    	while(result.next()){
    		X_min = result.getInt("Xmin_map");
    		X_max = result.getInt("Xmax_map");
    		Y_max = result.getInt("Ymax_map");
    		Y_min = result.getInt("Ymin_map");
    	}
    	
    	try {
			actualModel.getLevel().getTray().setBoundary(Factory.createBoundary(actualModel.getLevel().getTray(), X_min, X_max, Y_min, Y_max));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    public void getBlock (Model actualModel, int mapID) throws Exception{
    	
    	int X = 0, Y = 0;
    	String texture = "";
    	ResultSet result = statement.executeQuery("CALL getBlock('" + mapID + "');");
    
    	while(result.next()){
    		X = result.getInt("X_block");
    		Y = result.getInt("Y_block");
    		texture = result.getString("Name_block");
    		actualModel.getLevel().getTray().addTile(Factory.createTile(actualModel.getLevel().getBlocks().get(texture), Factory.createPosition(actualModel.getLevel().getTray(), X, Y)));
    	}
    }
    
    
    
    public void getEntity (Model actualModel, int mapID) throws Exception{
    	
    	int X = 0, Y = 0;
    	String entity = Factory.createString();
    	ResultSet result = statement.executeQuery("CALL getEntity('" + mapID + "');");
    
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
    
 
    
	public void closeDatabase() throws SQLException{
			
			statement.close();
			connection.close();
	}
}
