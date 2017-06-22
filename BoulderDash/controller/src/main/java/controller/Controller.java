package controller;

import java.util.Scanner;
import Icontroller.IController;
import Imodel.IModel;
import Imodel.IPosition;
import Iview.IView;
import menu.Launcher;
import model.Order;
import state.PreGamestate;
import view.KeyManager;
import view.Frame;

public class Controller implements IController{

	//private ControllerKeyBoard event;
	private IModel model;
	private IView view;
	private String MapName = Factory.createString();
	private String PlayerName = Factory.createString();
	private int MapID = 0;
	
	
	
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
		
		Launcher.runMenu();

		MapName = PreGamestate.getMapName();
		PlayerName = PreGamestate.getPlayerName();	

		ControllerDB database = Factory.createControllerDB();
		
		MapID = ControllerDAO.getIDmap(database, MapName);
		
		//Envoyer map existante a la vue.
		ControllerDAO.loadPlayer(database, PlayerName, getModel());
		ControllerDAO.loadEntity(database, getModel());
		ControllerDAO.loadBlock(database, getModel());
		
		ControllerDAO.loadSelectedMap(database, MapID, getModel());
		
		database.closeDatabase();
	}
	
	
	
	public void newGame() throws Exception{
		
		 try {
			 view = Factory.createView(model);
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
