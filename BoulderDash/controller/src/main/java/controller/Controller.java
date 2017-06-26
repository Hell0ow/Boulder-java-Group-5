package controller;

import Icontroller.IController;
import Imodel.IModel;
import Iview.IView;
import menu.Launcher;
import state.PreGamestate;
import view.KeyManager;
import view.Frame;

/**
 * <b> Controller is the principal class of the package controller. It launch and instantiate view and model.</br>
 * <p> Its job is to load element from ControllerDB and send them to model to initiate the view.</p>
 * 
 * @author Antoine Savalle
 * @version 4.0
 */
public class Controller implements IController{

	/**
	 * Model attribute.
	 * @see Controller#getModel()
	 * @see Controller#Controller()
	 */
	private IModel model;
	
	/**
	 * View attribute
	 * @see Controller#getView()
	 */
	private IView view;
	
	/**
	 * Name of the actual using map.
	 * @see Controller#initGame() -> MapName = PreGamestate.getMapName();
	 */
	private String MapName = Factory.createString();
	
	/**
	 * <p>Name of the new player.</p>
	 * @see Controller#initGame() -> PlayerName = PreGamestate.getPlayerName();
	 */
	private String PlayerName = Factory.createString();
	
	/**
	 * <p>ID which correspond, in database, to the actual map.</p>
	 * @see Controller#initGame() -> MapID = ControllerDAO.getIDmap(database, MapName);
	 */
	private int MapID = 0;
	
	
	/**
	 * <p>Controller constructor. When the controller is instantiate by something, controller constructor create a new model object.</p>
	 * @see Controller#model
	 * @throws Exception
	 */
	public Controller() throws Exception{
		model= Factory.createModel();
	}
	
	
	/**
	 * <p> This getter return the local model.</p>
	 * @return {@link Controller#model}
	 */
	public IModel getModel(){
		return model;
	}
	
	/**
	 * <p> This getter return the local view</p>
	 * @return {@link Controller#view}
	 */
	public IView getView(){
		return view;
	}
	
	
	/**
	 * <p> This method have to prepare the start of the game. It load data (map, player, block, ...) from our database
	 * 	   and launch the menu to select the player name and map. </p>
	 * @throws Exception
	 */
	public void initGame() throws Exception{
		
		//Instantiate new database object.
		ControllerDB database = Factory.createControllerDB();
	
		//Launch menu
		Launcher.runMenu();
		//Take map and player name
		MapName = PreGamestate.getMapName();
		PlayerName = PreGamestate.getPlayerName();	
		
		MapID = ControllerDAO.getIDmap(database, MapName);
		
		//Load player, entity, block and map (boundary, position) in the model.
		ControllerDAO.loadPlayer(database, PlayerName, getModel());
		ControllerDAO.loadEntity(database, getModel());
		ControllerDAO.loadBlock(database, getModel());
		
		ControllerDAO.loadSelectedMap(database, MapID, getModel());
		
		database.closeDatabase();
	}
	
	
	
	/**
	 * <p> This method have to launch the game after the menu. It create a new view to load the frame, load the camera, the key management, and, finally the refresh of the frame when an user give an order.</p>
	 * @throws Exception
	 */
	public void Game() throws Exception{
		
		 try {
			 view = Factory.createView(model);

			 KeyManager keyEvent = ((Frame) view.getFrame()).getKeyManager();
			 
	            do{
	            	Thread.sleep(10);
	                view.frame();
	               
	            }while(!model.cycle(ControllerKeyBoard.getOrder(keyEvent)));
	            
	            view.frame();
	            
	            if(model.isWon()){
	            	view.win();
	            }else{
	            	view.lose();
	            }
	            
	          
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
}
