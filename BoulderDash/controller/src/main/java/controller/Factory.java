package controller;

import model.*;
import model.Character;
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
	public static Model createModel(){
			try {
				return new Model();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	public static Human createHuman() throws Exception{
		return new Human();
	}
	
	public static Human createDummy() throws Exception{
		return new Human();
	}
	
	public static Player createPlayer(int idPlayer, String playerName){
		 return new Player(idPlayer, playerName);
	}
	
	public static Boundary createBoundary(Tray tray, Delimitations delimitations){
		return new Boundary(tray, delimitations);
	}
	
	public static Boundary createBoundary(Tray tray, int a, int b, int c, int d){
		try {
			return new Boundary(tray, a, b, c, d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
 	public static Tile createTile(Block block, Position position){
 		return new Tile(block, position);
 	}
 	
 	public static Position createPosition(Tray tray, int a, int b){
 		try {
			return new Position(tray, a, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return null;
 	}
 	
 	public static Hero createHero(Character character, Objective objective, Position position){
 		return new Hero(character, objective, position);
 	}
 	
 	public static Enemy createEnemy(Dummy dummy, Direction direction, Position position){
 		return new Enemy(dummy, direction, position);
 	}
 	
 	public static Diamond createDiamond() throws Exception{
 		return new Diamond();
 	}
 	
 	public static Rock createRock() throws Exception{
 		return new Rock();
 	}
 	
 	public static Air createAir() throws Exception{
		return new Air();
	}
 	
 	public static Mud createMud() throws Exception{
 		return new Mud();
 	}
 	
 	public static Wall createWall() throws Exception{
 		return new Wall();
 	}
	// ------------------------ //
	
	
	
	
	
	// ----- View Object ----- //
	public static IView createView(IModel model, ControllerKeyBoard controllerKey){
			return new View(model, controllerKey);
		}
	// ------------------------ //





}
