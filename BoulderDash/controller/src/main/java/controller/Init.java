package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Air;
import model.Block;
import model.Boundary;
import model.Character;
import model.Diamond;
import model.Dummy;
import model.Human;
import model.Model;
import model.Mud;
import model.Player;
import model.Position;
import model.Rock;
import model.Slab;
import model.Wall;


public class Init {

	private String user     = "java";
	private String password = "bigouneroot";
    private String url      = "jdbc:mysql://164.132.49.33:3306/boulderdash?useSSL=false&serverTimezone=UTC";
    private Connection connection = null;
    private Statement  statement;
    
    
    
    
    
    
    public Init(String user, String password){
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
    	
    	statement.executeUpdate("INSERT INTO PLAYER VALUES ('', '" + playerName + "')");
    }
    
    
    
    
    
    
    
    
    
    public void initPlayer(Model actualModel, String playerName) throws SQLException{
    	
    	ResultSet result = statement.executeQuery("SELECT ID_player FROM PLAYER WHERE Name_player = '" + playerName + "';");
    	
    	Integer idPlayer = 0;
		
		while(result.next()){
			idPlayer = result.getInt("ID_player");
		}
		
		Player actualPlayer = new Player(idPlayer, playerName);
		actualModel.setPlayer(actualPlayer);
    }
    
    
    
    
    
    
    
    public void getExistingBlockTexture(Model actualModel) throws SQLException{
    	
    	Block textureType = new Air();
    	int getID = 0;
    	ResultSet result = statement.executeQuery("SELECT ID_typeBlock FROM TYPEblock;");
    	
    	while(result.next()){
    		getID = result.getInt("ID_typeBlock");
    		switch(getID){
    		case 1:
    			textureType = new Diamond();
    			break;
    		case 2:
    			textureType = new Rock();
    			break;
    		case 3:
    			textureType = new Mud();
    			break;
    		case 4:
    			textureType = new Wall();
    			break;
    		case 5:
    			textureType = new Air();
    			break;
    		}
    		actualModel.getLevel().addBlock(textureType);	
    	}
    }
    
    
    
    
    
	public void getExistingEntity(Model actualModel) throws SQLException{
	    	
	    	Character entityType = new Human();
	    	int getID = 0;
	    	ResultSet result = statement.executeQuery("SELECT ID_typeEntity FROM TYPEentity;");
	    	
	    	while(result.next()){
	    		getID = result.getInt("ID_typeEntity");
	    		switch(getID){
	    		case 1:
	    			entityType = new Human();
	    			break;
	    		case 2:
	    			entityType = new Dummy();
	    			break;
	    		case 3:
	    			entityType = new Dummy();
	    			break;
	    		case 4:
	    			entityType = new Dummy();
	    			break;
	    		case 5:
	    			entityType = new Dummy();
	    			break;
	    		case 6:
	    			entityType = new Dummy();
	    			break;
	    		case 7:
	    			entityType = new Dummy();
	    			break;
	    		default:
	    			
	    		}
	    		actualModel.getLevel().addCharacter(entityType);	
	    	}
	   }
    
    
    
    public void getBoundary (Model actualModel, int mapID) throws SQLException{
    	
    	int X_max = 0, X_min = 0, Y_max = 0, Y_min = 0;
    	
    	ResultSet result = statement.executeQuery("SELECT Xmin_map, Xmax_map, Ymax_map, Ymin_map FROM MAP WHERE ID_map = '" + mapID + "';");
    	
    	while(result.next()){
    		X_min = result.getInt("Xmin_map");
    		X_max = result.getInt("Xmax_map");
    		Y_max = result.getInt("Ymax_map");
    		Y_min = result.getInt("Ymin_map");
    	}
    	
    	try {
			actualModel.getLevel().getTray().setBoundary(new Boundary(actualModel.getLevel().getTray(), X_min, X_max, Y_min, Y_max));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    public void getBlock (Model actualModel, int mapID) throws Exception{
    	
    	int X = 0, Y = 0;
    	String texture = "";
    	ResultSet result = statement.executeQuery("SELECT X_block, Y_block, TYPEblock.Name_block FROM BLOCK INNER JOIN TYPEblock ON BLOCK.ID_typeBlock = TYPEblock.ID_typeBlock WHERE ID_map = '" + mapID + "';");
    
    	while(result.next()){
    		X = result.getInt("X_block");
    		Y = result.getInt("Y_block");
    		texture = result.getString("Name_block");
    		actualModel.getLevel().getTray().addSlab(new Slab(actualModel.getLevel().getBlocks().get(texture), new Position(actualModel.getLevel().getTray(), X, Y)));
    	}
    }
    
    
    
    public void getEntity (int mapID){
    	
    }
    
    
    
    public void getHuman (int mapID){
    	
    }
    
	public void closeDatabase() throws SQLException{
			
			statement.close();
			connection.close();
	}
    
    
    
}
