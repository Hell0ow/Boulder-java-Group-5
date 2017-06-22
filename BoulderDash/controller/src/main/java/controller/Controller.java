package controller;

import java.util.Scanner;

import Icontroller.IController;
import Imodel.IModel;
import Iview.IView;
import menu.Launcher;
import model.Order;

public class Controller implements IController{

	//private ControllerKeyBoard event;
	private IModel model;
	private IView view;
	
	
	
	public Controller() throws Exception{
		model= Factory.createModel();
		
		view = Factory.createView(model/*, event*/);
	}
	
	
	public IModel getModel(){
		return model;
	}
	
	public IView getView(){
		return view;
	}
	
	
	public void initGame() throws Exception{
		
		Launcher.runMenu();
		
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
		
		 try {
	            while(true) {

	                view.frame();

	                model.cycle(getOrder());
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	
	
	public static Order getOrder() {
        Scanner sc = new Scanner(System.in);

        sc.hasNextLine();

        String string = sc.nextLine();

        switch(string) {
            case "MOVE_UP":
                return Order.MOVE_UP;
            case "MOVE_RIGHT":
                return Order.MOVE_RIGHT;
            case "MOVE_DOWN":
                return Order.MOVE_DOWN;
            case "MOVE_LEFT":
                return Order.MOVE_LEFT;
            case "DIG_UP":
                return Order.DIG_UP;
            case "DIG_RIGHT":
                return Order.DIG_RIGHT;
            case "DIG_DOWN":
                return Order.DIG_DOWN;
            case "DIG_LEFT":
                return Order.DIG_LEFT;
            default:
                return Order.NONE;
        }
    }
}
