package gfx;

import menu.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Assets {

    public static BufferedImage background, titleAnimation;
    public static Rectangle playButton, settingsButton;

    public static void init(){
        background = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/backgroun.png");
        titleAnimation = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/Title_boulder.png");
    }
}
