package controller;

import java.awt.event.KeyEvent;

import model.Air;
import model.Block;
import model.Boundary;
import model.Character;
import model.Delimitations;
import model.Diamond;
import model.Direction;
import model.Dummy;
import model.Enemy;
import model.Hero;
import model.Human;
import model.Model;
import model.Mud;
import model.Objective;
import model.Player;
import model.Position;
import model.Rock;
import model.Tile;
import model.Tray;
import model.Wall;
import view.ViewFacade;

public abstract class Factory {
	
	// ------ Java Object ------ //
	public static String createString(){
		return new String();
	}
	
	public static KeyEvent createKeyEvent(){
		return new KeyEvent(null, 0, 0, 0, 0);
	}
	// ------------------------ //
	
	
	
	
	
	// --- Controller Object --- //
	public static Init createInit(){
		return new Init("java", "bigouneroot");
	}
	
	public final static EventGame createEventGame(){
		return new EventGame();
	}
	
	public static Menu createMenu(){
		return new Menu();
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
	
	public static Human createHuman(){
		return new Human(null, 0, 0);
	}
	
	public static Human createDummy(){
		return new Human(null, 0, 0);
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
 	
 	public static Diamond createDiamond(){
 		return new Diamond();
 	}
 	
 	public static Rock createRock(){
 		return new Rock();
 	}
 	
 	public static Air createAir(){
		return new Air();
	}
 	
 	public static Mud createMud(){
 		return new Mud();
 	}
 	
 	public static Wall createWall(){
 		return new Wall();
 	}
	// ------------------------ //
	
	
	
	
	
	// ----- View Object ----- //
	public static ViewFacade createView(){
			return new ViewFacade();
		}
	// ------------------------ //

}
