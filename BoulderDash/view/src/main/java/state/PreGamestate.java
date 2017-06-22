package state;

import javax.swing.*;

import menu.Game;

import java.awt.*;

/**
 * Created by Nico on 22/06/2017.
 */
public class PreGamestate extends State{

    private static String mapName;
    private static String playerName;
    private static boolean asking;

    public PreGamestate(){
        mapName = "";
        playerName = "";
        asking = false;
    }

    @Override
    public void tick() {
        playerName = JOptionPane.showInputDialog("What is your nickname?");
        mapName = JOptionPane.showInputDialog("Which map will you choose?");
        asking = true;
    }

    @Override
    public void render(Graphics g) {

        State.setState(Game.getGamestate());
    }
    
    public static String  getMapName(){
    	while(asking == false){
    		System.out.println("wait mapName");
    	}
    	return mapName;
    }
    
    public static String  getPlayerName(){
    	while(asking == false){
    		System.out.println("wait playerName");
    	}
    	return playerName;
    }
}
