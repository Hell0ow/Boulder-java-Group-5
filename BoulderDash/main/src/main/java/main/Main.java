package main;


import java.sql.SQLException;
import controller.Controller;


public abstract class Main {

    public static void main(final String[] args) {
    	
        Controller start = new Controller();
        
        //Initialisation du jeu;
        try {
			start.initialLoad();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
