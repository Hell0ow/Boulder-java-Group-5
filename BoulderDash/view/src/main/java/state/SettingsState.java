package state;

import gfx.Assets;
import menu.Display;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class SettingsState extends State {

    public SettingsState(){

    }

    @Override
    public  void tick(){

    }

    @Override
    public  void render(Graphics g){
        g.drawImage(Assets.background, 0,0, Display.getWidthframe(), Display.getHeightframe(), null);



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
        g.drawString("SETTINGS", Display.getHeightframe() / 2 , Display.getHeightframe() /  4 - 30);

    }

}

