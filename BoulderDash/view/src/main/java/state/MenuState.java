package state;


import menu.Display;
import gfx.Assets;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 *
 * Animation and images in the menu
 */
public class MenuState extends State{

    private static int x;
    private static int y;
    private static boolean a;
    /**
     * The constant playButton.
     */
    public static Rectangle playButton, 
    /**
     * The Settings button.
     */
    settingsButton,
    /**
     * The Quit button.
     */
    quitButton;
    /**
     * Instantiates a new Menu state.
     */
    private static JLabel label;

    public MenuState() {

        x = 0;
        y = 0;
        a = true;
    }

    @Override
    public  void tick(){
        if(x <= 21 && y <= 21 && a == true) {         //Title Animation
            x++;
            y++;
            if(x >=20 && y>=20)
                a = false;
        }
        else if(a == false) {
            x--;
            y--;
            if(x<=1 && y<=1)
                a = true;
        }
        //addMouseListener(new AppletMouse());
    }

    /**
     * Display the background, title and  the different buttons
     * @param g the g
     */
    @Override
    public  void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(Assets.background,0,0, Display.getWidthframe(), Display.getHeightframe(), null);
        g.drawImage(Assets.titleAnimation, Display.getWidthframe() /4,-80,Display.getWidthframe() / 2 + x / 3, Display.getHeightframe() / 2 + y / 3, null);


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
        g.drawString("BIENVENUE", Display.getHeightframe() / 2 , Display.getHeightframe() /  2 - 30);


        playButton = new Rectangle(Display.getWidthframe() / 3 + 40,Display.getHeightframe()/2 +40,300,50);
        settingsButton = new Rectangle(Display.getWidthframe()/3 + 40,Display.getHeightframe()/2 + 150,300,50);
        quitButton = new Rectangle(Display.getWidthframe() / 3 +40, Display.getHeightframe()/2 + 260, 300,50);


        g2d.draw(playButton);
        g2d.draw(settingsButton);
        g2d.draw(quitButton);

        Font fnt1 = null;
        try {
            fnt1 = Font.createFont(Font.TRUETYPE_FONT, new File("D:/CESI année 1/Projet/Java/Font/slkscr.ttf")).deriveFont(Font.PLAIN, 55);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.setColor(Color.green);
        g.setFont(fnt1);
        g.drawString("Play", playButton.x + 65, playButton.y + 45);
        g.drawString("Settings", settingsButton.x + 17, settingsButton.y + 45);
        g.drawString("Quit", quitButton.x + 90, quitButton.y + 45);



    }


}
