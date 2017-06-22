package state;

import javax.swing.*;

import menu.Display;

import java.awt.*;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class GameState extends State{
    public GameState(){

    }

    @Override
    public  void tick(){
    	Display.getFrame().dispose();
    }

    @Override
    public void render(Graphics g) {
    }


}
