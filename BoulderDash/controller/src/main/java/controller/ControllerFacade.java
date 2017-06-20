package controller;

import model.Model;
import view.ViewFacade;

public class ControllerFacade {

	private Init launch = new Init("java", "bigouneroot");
	private Model model;
	private ViewFacade view;
	
	
	
	public ControllerFacade() throws Exception{
		model= new Model();
		view = new ViewFacade();
	}
	
	
	public Model getModel(){
		return model;
	}
	
	public ViewFacade getView(){
		return view;
	}
	
	
	public void initialLoad() throws Exception{
		
		//Lancer la vue et demander l'utilisateur
		//Recuperer utilisateur sur la vue
		String playerName = "T";
		
		launch.addPlayer(playerName);
		
		//On initialise le joueur dans model.
		launch.initPlayer(model, playerName);
		
		//On charge les textures existantes.
		launch.getExistingBlockTexture(model);
		
		//On charge les entités existantes.
		launch.getExistingEntity(model);
		
		//Lancer la demande le choix de carte via la vue.
		int mapID = 1;
		
		//On charge les délimitation de la map.
		launch.getBoundary(model, mapID);
		
		//On charge les blocs
		launch.getBlock(model, mapID);
		
		// On charge les entités
		launch.getEntity(model, mapID);
		
		//On ferme la connection
		launch.closeDatabase();
		
		
	}
}
