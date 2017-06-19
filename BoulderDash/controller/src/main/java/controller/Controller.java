package controller;
import java.sql.SQLException;

import model.Model;
import model.Player;
import view.ViewFacade;

public class Controller {

	private ControllerInit launch = new ControllerInit("java", "bigouneroot");
	private Model model;
	private ViewFacade view;
	
	
	
	public Controller(){
		model= new Model();
		view = new ViewFacade();
	}
	
	
	
	public void initialLoad() throws SQLException{
		
		//Lancer la vue et demander l'utilisateur
		//Recuperer utilisateur sur la vue
		String playerName = "Bigoune";
		
		launch.addPlayer(playerName);
		
		//On initialise le joueur dans model.
		launch.initPlayer(model, playerName);
		
		//On charge les textures existantes.
		launch.getExistingBlockTexture(model);
		
		//On charge les entit�s existantes.
		launch.getExistingEntity(model);
		
		//Lancer la demande le choix de carte via la vue.
		String map = "Valhala";
		
		//On charge les d�limitation de la map.
		launch.getBoundary(model, map);
		
		launch.closeDatabase();
		
		
	}
}
