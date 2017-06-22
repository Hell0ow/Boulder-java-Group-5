package state;

import javax.swing.*;

import menu.Game;

import java.awt.*;

/**
 * Created by Nico on 22/06/2017.
 */
public class PreGamestate extends State{

    private String mapName;
    private String playerName;

    public PreGamestate(){
        mapName = "";
        playerName = "";
    }

    @Override
    public void tick() {
        playerName = JOptionPane.showInputDialog("What is your nickname?");
        mapName = JOptionPane.showInputDialog("Which map will you choose?");
    }

    @Override
    public void render(Graphics g) {


        JOptionPane.showMessageDialog(null, "Hello " + playerName + ", you chose the map " + mapName);

        State.setState(Game.getGamestate());
    }
}
