package controller;

import java.sql.SQLException;

import model.Model;
import view.ViewFacade;

public class Controller{

	private ControllerKeyBoard event;
	private Model model;
	private ViewFacade view;
	
	
	
	public Controller() throws Exception{
		model= Factory.createModel();
		
		event = Factory.createControllerKeyBoard(getModel());
		
		//view = Factory.createView(event);
	}
	
	
	public Model getModel(){
		return model;
	}
	
	public ViewFacade getView(){
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
		
		String playerName = Factory.createString(); // Demander a la vue le nom du joueur.
		int mapID = 1; // Demander a la vue la carte.
		ControllerDAO.loadPlayer(database, playerName, getModel());
		ControllerDAO.loadSelectedMap(database, mapID, getModel());
		
		database.closeDatabase();
	}
}
