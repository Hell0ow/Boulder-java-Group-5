package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b>ControllerDB is the link between database and boulderdash</b>
 * <p>This class have to execute all stocked procedure and, if needed, return a result as ResultSet.</p>
 * 
 * @author Antoine Savalle
 * @version 2.0
 * @see Controller#initGame()
 */
public class ControllerDB{
	
	/**
	 * <p>User is the string needed to establish a connection with our database.</p>
	 * @see ControllerDB#ControllerDB(String, String).
	 */
	private String user     = "java";
	
	/**
	 * <p>Password is the string needed to be identified in our database.</p>
	 * @see ControllerDB#ControllerDB(String, String).
	 */
	private String password = "bigouneroot";
	
	/**
	 * <p>Url is needed to precise the address of our database.</p>
	 */
    private String url      = "jdbc:mysql://164.132.49.33:3306/boulderdash?useSSL=false&serverTimezone=UTC";
    
    /**
     * <p>Connection stock the driver manager used to establish the link between ControllerDB and database.</p>
     * @see ControllerDB#ControllerDB(String, String).
     */
    private Connection connection = null;
    
    /**
     * <p>Statement allow to create new SQL request.</p>
     * @see ControllerDB#ControllerDB(String, String).
     */
    private Statement  statement = null;
	
	
    /**
     * <p> ControllerDB constructor. Recover the user and password. Initiate the connection and statement.</p>
     * @param user
     * @param password
     * @throws Exception
     */
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
	
    /**
     * <p> This method launch a SQL request to recover all existing map name.</p>
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */
    protected ResultSet getAllMapName() throws SQLException{
    	ResultSet result = statement.executeQuery("CALL getAllMapName();");
    	return result;
    }
    
    /**
     * <p> This method launch a SQL request to recover the map id which correspond to the mapName.</p>
     * @param mapName : String
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */
    protected ResultSet getIDmap(String mapName) throws SQLException{
    	ResultSet result = statement.executeQuery("CALL getMapID ('" + mapName + "');");
    	return result;
    }
    
    /**
     * <p> This method launch a SQL request to add the name of a new player in our database.</p>
     * @param playerName : String
     * @throws SQLException
     */
    protected void addPlayer(String playerName) throws SQLException{
		statement.executeUpdate("CALL addPlayer('" + playerName + "');");
	}
	   
    /**
     * <p> This method launch a SQL request to recover the player id which correspond to the player name.</p>
     * @param playerName : String
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */
    protected ResultSet initPlayer(String playerName) throws SQLException{
		ResultSet result = statement.executeQuery("CALL initPlayer('" + playerName + "');");
    	return result;
	}
	    
    /**
     * <p> This method launch a SQL request to recover all existing type of block stocked in our database.</p>
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */    
    protected ResultSet getExistingBlockTexture() throws SQLException{
	    ResultSet result = statement.executeQuery("CALL getBlockTexture();");
	    return result;
	}
	    
    /**
     * <p> This method launch a SQL request to recover all existing type of entity stocked in our database.</p>
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */
    protected ResultSet getExistingEntity() throws SQLException{
		ResultSet result = statement.executeQuery("CALL getAllEntityName();");
		return result;
	}
	    
    /**
     * <p> This method launch a SQL request to recover the boundary relative to a map ID.</p>
     * @param mapID : int
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */
    protected ResultSet getBoundary (int mapID) throws SQLException{
		ResultSet result = statement.executeQuery("CALL getBoundary('" + mapID + "');");
		return result;
	}
	    
    /**
     * <p> This method launch a SQL request to recover all blocks relative to a map ID.</p>
     * @param mapID : int
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */    
    protected ResultSet getBlock (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getBlock('" + mapID + "');");
		return result;
	}
	    
    /**
     * <p> This method launch a SQL request to recover all entity relative to a map ID.</p>
     * @param mapID : int
     * @return ResultSet type who contain request result.
     * @throws SQLException
     */      
    protected ResultSet getEntity (int mapID) throws Exception{
		ResultSet result = statement.executeQuery("CALL getEntity('" + mapID + "');");
		return result;
	
	}
	    
    /**
     * <p> This method close the link between ControllerDB and database. 
     * @throws SQLException
     */
    protected void closeDatabase() throws SQLException{
			statement.close();
			connection.close();
	}
}
