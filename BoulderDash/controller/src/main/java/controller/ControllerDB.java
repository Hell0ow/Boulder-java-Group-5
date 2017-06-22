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
	
	
    public ControllerDB(String user, String password) throws Exception {
		
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
	
    
    
    public ResultSet getIDmap(String mapName) throws SQLException{
    	ResultSet result = statement.executeQuery("CALL getMapID ('" + mapName + "');");
    	return result;
    }
    
    
	public void addPlayer(String playerName) throws SQLException{
		statement.executeUpdate("CALL addPlayer('" + playerName + "');");
	}
	   
	 
	public ResultSet initPlayer(String playerName) throws SQLException{
		ResultSet result = statement.executeQuery("CALL initPlayer('" + playerName + "');");
    	return result;
	}
	    
	    
	public ResultSet getExistingBlockTexture() throws SQLException{
	    ResultSet result = statement.executeQuery("CALL getBlockTexture();");
	    return result;
	}
	    
	    
	public ResultSet getExistingEntity() throws SQLException{
		ResultSet result = statement.executeQuery("CALL getAllEntityName();");
		return result;
	}
	    
	    
	public ResultSet getBoundary (int mapID) throws SQLException{
		ResultSet result = statement.executeQuery("CALL getBoundary('" + mapID + "');");
		return result;
	}
	    
	    
	public ResultSet getBlock (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getBlock('" + mapID + "');");
		return result;
	}
	    
	     
	public ResultSet getEntity (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getEntity('" + mapID + "');");
		return result;
	
	}
	    
	   
	public void closeDatabase() throws SQLException{
			statement.close();
			connection.close();
	}
}
