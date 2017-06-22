package state;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class GameState extends State{
    public GameState(){

    }

    @Override
    public  void tick(){
        JOptionPane.showMessageDialog(null, "t'es dans l'état game");
        System.exit(-1);
    }

    @Override
    public void render(Graphics g) {

    }


}
