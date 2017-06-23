package controller;

import java.util.ArrayList;
import java.util.List;
import Icontroller.IController;
import Imodel.IModel;
import Iview.IView;
import menu.Launcher;
import state.PreGamestate;
import view.KeyManager;
import view.Camera;
import view.Frame;

/**
 * <b> Controller is the principal class of the package controller. It launch and instantiate view and model.</br>
 * <p> His job is to load element from ControllerDB and send them to model to initiate the view.</p>
 * @author antoi
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
	 * Name of the new player.
	 * @see Controller#initGame() -> PlayerName = PreGamestate.getPlayerName();
	 */
	private String PlayerName = Factory.createString();
	
	/**
	 * ID which correspond, in database, to the actual map.
	 * @see Controller#initGame() -> MapID = ControllerDAO.getIDmap(database, MapName);
	 */
	private int MapID = 0;
	
	
	/**
	 * Controller contructor.
	 * @throws Exception
	 */
	public Controller() throws Exception{
		model= Factory.createModel();
	}
	
	
	public IModel getModel(){
		return model;
	}
	
	public IView getView(){
		return view;
	}
	
	
	public void initGame() throws Exception{
		
		ControllerDB database = Factory.createControllerDB();
		
		List<String> map = new ArrayList<String>();
		map = ControllerDAO.getAllMapName(database);
		PreGamestate.setMapList(map);
		
		Launcher.runMenu();
		MapName = PreGamestate.getMapName();
		PlayerName = PreGamestate.getPlayerName();	
		
		MapID = ControllerDAO.getIDmap(database, MapName);

		ControllerDAO.loadPlayer(database, PlayerName, getModel());
		ControllerDAO.loadEntity(database, getModel());
		ControllerDAO.loadBlock(database, getModel());
		
		ControllerDAO.loadSelectedMap(database, MapID, getModel());
		
		database.closeDatabase();
	}
	
	
	
	public void Game() throws Exception{
		
		 try {
			 view = Factory.createView(model);
			 Camera cam = new Camera(model, 0, 0);
			 KeyManager keyEvent = ((Frame) view.getFrame()).getKeyManager();
			 
	            do{
	            	Thread.sleep(500);
	                view.frame();
	               
	            }while(!model.cycle(ControllerKeyBoard.getOrder(keyEvent)));
	            
	            view.frame();
	            
	            
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
}
