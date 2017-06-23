package state;

import menu.Display;
import gfx.Assets;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 **/
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
            fnt0 = Font.createFont(Font.TRUETYPE_FONT, new File("D:/CESI année 1/Projet/Java/Font/slkscr.ttf")).deriveFont(Font.PLAIN, 55);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.setFont(fnt0);
        g.setColor(Color.red);
        g.drawString("SETTINGS", Display.getHeightframe() / 2 , 70);
        g.drawString("BACK", 80, Display.getHeightframe()-70);
        g.drawString("Sound: ",Display.getWidthframe()-600,Display.getHeightframe()-70);
        g.drawImage(Assets.speaker_muted, Display.getWidthframe() - 370, Display.getHeightframe() -110,50,50, null);
        g.drawImage(Assets.speaker_low, Display.getWidthframe() - 250, Display.getHeightframe()-110,50,50,null);
        g.drawImage(Assets.speaker_high, Display.getWidthframe() - 130, Display.getHeightframe() - 110 ,50,50,null);

        g.setColor(Color.green);
        g.drawString("Size: 1280960", MenuState.playButton.x-300 , MenuState.playButton.y -200);
        g.drawString("Size: 1152*832", MenuState.playButton.x-300 , MenuState.playButton.y -100);
        g.drawString("FPS : ", MenuState.playButton.x -300, MenuState.playButton.y +50);
        g.drawImage(Assets.canSee, MenuState.playButton.x -140, MenuState.playButton.y -40, null);
        g.drawImage(Assets.cantSee, MenuState.playButton.x +30, MenuState.playButton.y -45,140,140, null);


    }

}