package controller;

import modelContract.*;
import model.*;
import view.IView;
import view.View;

public abstract class Factory {
	
	// ------ Java Object ------ //
	public static String createString(){
		return new String();
	}
	// ------------------------ //
	
	
	
	
	
	// --- Controller Object --- //
	
	public static ControllerDB createControllerDB() {
		// TODO Auto-generated method stub
		try {
			return new ControllerDB("java", "bigouneroot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// ------------------------ //
	
	
	
	
	
	// ----- Model Object ----- //
	public static IModel createModel(){
			try {
				return (IModel) new Model();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	public static IHuman createHuman() throws Exception{
		return (IHuman) new Human();
	}
	
	public static IHuman createDummy() throws Exception{
		return (IHuman) new Human();
	}
	
	public static IPlayer createPlayer(int idPlayer, String playerName){
		 return (IPlayer) new Player(idPlayer, playerName);
	}
	
	public static IBoundary createBoundary(ITray tray, IDelimitations delimitations){
		return (IBoundary) new Boundary(((Ttray, delimitations);
	}
	
	public static IBoundary createBoundary(ITray iTray, int a, int b, int c, int d){
		try {
			return (IBoundary) new Boundary((Tray) iTray, a, b, c, d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
 	public static ITile createTile(IBlock iBlock, Position position){
 		return new Tile(iBlock, (IPosition) position);
 	}
 	
 	public static IPosition createPosition(Tray tray, int a, int b){
 		try {
			return (IPosition) new Position(tray, a, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return null;
 	}
 	
 	public static IHero createHero(IHuman iHuman, IObjective iObjective, Position position){
 		return (IHero) new Hero((Character) iHuman, (Objective) iObjective, position);
 	}
 	
 	public static IEnemy createEnemy(IDummy iDummy, Direction direction, Position position){
 		return (IEnemy) new Enemy((Dummy) iDummy, direction, position);
 	}
 	
 	public static IDiamond createDiamond() throws Exception{
 		return new Diamond();
 	}
 	
 	public static IRock createRock() throws Exception{
 		return new Rock();
 	}
 	
 	public static IAir createAir() throws Exception{
		return new Air();
	}
 	
 	public static IMud createMud() throws Exception{
 		return new Mud();
 	}
 	
 	public static IWall createWall() throws Exception{
 		return new Wall();
 	}
	// ------------------------ //
	
	
	
	
	
	// ----- View Object ----- //
	public static IView createView(IModel model, ControllerKeyBoard controllerKey){
			return new View(model, controllerKey);
		}
	// ------------------------ //





	public static IPosition createPosition(ITray tray, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}





}
