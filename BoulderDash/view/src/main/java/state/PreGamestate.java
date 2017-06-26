package BoulderDash.State;

import BoulderDash.Display;
import BoulderDash.Game;
import BoulderDash.gfx.Assets;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nico on 22/06/2017.
 */
public class PreGamestate extends State{


    private int imageWidth, imageHeight;

    private static int mapChoosen;

    private static String playerNickname;
    private boolean check = false;
    private static boolean game = false;
    String[] array = {"Hell", "test", "Espoir", "Antoine"};

    public PreGamestate(){
        imageHeight = 400;
        imageWidth = 400;
        mapChoosen = 0;
    }

    @Override
    public void tick() {
        if(!check) {
            playerNickname = JOptionPane.showInputDialog("What's your nickname?");
            check = true;
        }

        if(game)
            State.setState(Game.getGamestate());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0,0, Display.getWidthframe(),Display.getHeightframe(), null);


        Font fnt0 = null;
        try {
            fnt0 = Font.createFont(Font.TRUETYPE_FONT, new File("out/font/slkscr.ttf")).deriveFont(Font.PLAIN, 55);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.setFont(fnt0);
        g.setColor(Color.red);

        g.drawString("PLAY !", 490,780);

        g.drawString("Choose your map: ", 300,100);


        g.drawImage(Assets.right_arrow,800,300, 200,110,null);
        g.drawImage(Assets.left_arrow, 150, 300,200,100,null);

        g.setColor(Color.green);

        if(mapChoosen == 0){
            g.drawString(array[0], 490,280);
            g.drawImage(Assets.map0, 380,300,imageWidth,imageHeight,null);
        }
        if(mapChoosen == 1){
            g.drawString(array[1], 490,280);
            g.drawImage(Assets.map1, 380,300,imageWidth,imageHeight,null);
        }
        if(mapChoosen == 2) {
            g.drawString(array[2], 490, 280);
            g.drawImage(Assets.map2, 380,300,imageWidth, imageHeight, null);
        }
        if(mapChoosen == 3){
            g.drawString(array[3], 490,280);
            g.drawImage(Assets.map3, 380,300,imageWidth, imageHeight, null);
        }
    }


    public static boolean isGame() {
        return game;
    }

    public static void setGame(boolean gamee) {
        game = gamee;
    }

    public static  int getMapChoosen() {
        return mapChoosen;
    }


    public static void setMapChoosen(int map) {
        mapChoosen = map;
    }
}
