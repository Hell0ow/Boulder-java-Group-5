package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerDB{
	
	private String user     = "java";
	private String password = "bigouneroot";
    private String url      = "jdbc:mysql://164.132.49.33:3306/boulderdash?useSSL=false&serverTimezone=UTC";
    private Connection connection = null;
    private Statement  statement = null;
	
	
    protected ControllerDB(String user, String password) throws Exception {
		
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
	
    
    
    protected ResultSet getIDmap(String mapName) throws SQLException{
    	ResultSet result = statement.executeQuery("CALL getMapID ('" + mapName + "');");
    	return result;
    }
    
    
    protected void addPlayer(String playerName) throws SQLException{
		statement.executeUpdate("CALL addPlayer('" + playerName + "');");
	}
	   
	 
    protected ResultSet initPlayer(String playerName) throws SQLException{
		ResultSet result = statement.executeQuery("CALL initPlayer('" + playerName + "');");
    	return result;
	}
	    
	    
    protected ResultSet getExistingBlockTexture() throws SQLException{
	    ResultSet result = statement.executeQuery("CALL getBlockTexture();");
	    return result;
	}
	    
	    
    protected ResultSet getExistingEntity() throws SQLException{
		ResultSet result = statement.executeQuery("CALL getAllEntityName();");
		return result;
	}
	    
	    
    protected ResultSet getBoundary (int mapID) throws SQLException{
		ResultSet result = statement.executeQuery("CALL getBoundary('" + mapID + "');");
		return result;
	}
	    
	    
    protected ResultSet getBlock (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getBlock('" + mapID + "');");
		return result;
	}
	    
	     
    protected ResultSet getEntity (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getEntity('" + mapID + "');");
		return result;
	
	}
	    
	   
    protected void closeDatabase() throws SQLException{
			statement.close();
			connection.close();
	}
}
