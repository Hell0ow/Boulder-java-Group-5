package state;

import javax.swing.*;

import menu.Game;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nico on 22/06/2017.
 */
public class PreGamestate extends State{

    private static String mapName;
    private static String playerName;
    private static boolean asking;
    private static List<String> mapList = new ArrayList<String>();

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
    
    public static String  getMapName() throws InterruptedException{
    	while(asking == false){
    		Thread.sleep(1);
    	}
    	return mapName;
    }
    
    public static String  getPlayerName() throws InterruptedException{
    	while(asking == false){
    		Thread.sleep(1);
    	}
    	return playerName;
    }
    
    public static void setMapList(List<String> pmapList){
    	mapList = pmapList;
    }
}
