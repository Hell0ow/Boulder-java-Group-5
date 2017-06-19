package main;


import java.sql.SQLException;
import controller.ControllerFacade;


public abstract class Main {

    public static void main(final String[] args) throws Exception {
    	
        ControllerFacade start = new ControllerFacade();
        
        //Initialisation du jeu;
        try {
			start.initialLoad();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
