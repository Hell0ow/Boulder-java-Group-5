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
    private static String mapList[];
    
    /**
     * Instantiates a new Pre gamestate.
     */

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
    /**
     *
     * @param g the g
     */

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
    
    public static void setMapList(String pmapList[]){
    	int sizeTable = pmapList.length;
    	mapList = new String[sizeTable];
    	
    	for(int i = 0; i < sizeTable; i++){
    		mapList[i] = pmapList[i];
    	}
    }
}
