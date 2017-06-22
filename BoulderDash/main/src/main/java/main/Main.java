package main;


import java.sql.SQLException;

import Icontroller.IController;
import controller.Controller;


public abstract class Main {

    public static void main(final String[] args) throws Exception {
    	
        IController start = new Controller();
        
        //Initialisation du jeu;
        try {
			start.initGame();
			//start.newGame();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
