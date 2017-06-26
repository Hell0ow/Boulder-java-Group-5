package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Assets {

    public static BufferedImage background, titleAnimation;
    public static BufferedImage speaker_muted, speaker_low, speaker_high, canSee, cantSee, left_arrow, right_arrow;
    public static Rectangle playButton, settingsButton;
    public static BufferedImage map0, map1, map2, map3;

    public static void init(){
        background = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/backgroun.png");
        titleAnimation = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/Title_Boulder.png");
        speaker_muted = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/no_volume.png");
        speaker_low = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/minus_volume.png");
        speaker_high = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/plus_volume.png");
        canSee = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/yeux.png");
        cantSee = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/yeux_barre.png");
        map0 = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/map0.PNG");
        map1 = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/map1.PNG");
        map2 = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/map2.PNG");
        map3 = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/map3.PNG");
        left_arrow =  ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/fleche_gauche.PNG");
        right_arrow = ImageLoader.loadImage("D:/CESI année 1/Projet/Java/Sprites/fleche_droite.PNG");
    }
}
