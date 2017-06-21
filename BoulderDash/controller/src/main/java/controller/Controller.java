package controller;

import modelContract.IModel;
import view.IView;

public class Controller implements IController{

	private ControllerKeyBoard event;
	private IModel model;
	private IView view;
	
	
	
	public Controller() throws Exception{
		model= Factory.createModel();
		
		view = Factory.createView(model, event);
	}
	
	
	public IModel getModel(){
		return model;
	}
	
	public IView getView(){
		return view;
	}
	
	
	public void initGame() throws Exception{
		
		ControllerDB database = Factory.createControllerDB();
		
		//Envoyer map existante a la vue.
		ControllerDAO.loadEntity(database, getModel());
		ControllerDAO.loadBlock(database, getModel());
		
		database.closeDatabase();
		
		
	}
	
	public void newGame() throws Exception{
		
		ControllerDB database = Factory.createControllerDB();
		
		String playerName = "SuperMan"; // Demander a la vue le nom du joueur.
		int mapID = 4; // Demander a la vue la carte.
		ControllerDAO.loadPlayer(database, playerName, getModel());
		ControllerDAO.loadSelectedMap(database, mapID, getModel());
		
		database.closeDatabase();
	}
}
