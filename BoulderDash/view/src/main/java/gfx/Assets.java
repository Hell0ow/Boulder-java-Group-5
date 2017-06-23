package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Assets {

    public static BufferedImage background, titleAnimation;
    public static BufferedImage speaker_muted, speaker_low, speaker_high, canSee, cantSee;
    public static Rectangle playButton, settingsButton;

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