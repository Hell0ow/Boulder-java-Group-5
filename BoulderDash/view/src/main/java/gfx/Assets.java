package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nicolas on 21/06/2017.
 * load all the images
 */
public class Assets {
/**
     * The constant background.
     */
    public static BufferedImage background,
    /**
     * The Title animation.
     */
    titleAnimation;
    /**
     * The image for Display the fps number and set the music's volume
     */
    public static BufferedImage speaker_muted, speaker_low, speaker_high, canSee, cantSee;
    public static Rectangle playButton, settingsButton;
    /**
    * Init. load image
    */

    public static void init(){
        background = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/backgroun.png");
        titleAnimation = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/Title_Boulder.png");
        speaker_muted = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/no_volume.png");
        speaker_low = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/minus_volume.png");
        speaker_high = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/plus_volume.png");
        canSee = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/yeux.png");
        cantSee = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/yeux_barre.png");
    }
}
