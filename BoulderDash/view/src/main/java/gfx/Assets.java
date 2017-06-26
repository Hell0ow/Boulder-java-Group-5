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
        background = ImageLoader.loadImage("out/img/backgroun.png");
        titleAnimation = ImageLoader.loadImage("out/img/Title_Boulder.png");
        speaker_muted = ImageLoader.loadImage("out/img/no_volume.png");
        speaker_low = ImageLoader.loadImage("out/img/minus_volume.png");
        speaker_high = ImageLoader.loadImage("out/img/plus_volume.png");
        canSee = ImageLoader.loadImage("out/img/yeux.png");
        cantSee = ImageLoader.loadImage("out/img/yeux_barre.png");
        map0 = ImageLoader.loadImage("out/img/map0.PNG");
        map1 = ImageLoader.loadImage("out/img/map1.PNG");
        map2 = ImageLoader.loadImage("out/img/map2.PNG");
        map3 = ImageLoader.loadImage("out/img/map3.PNG");
        left_arrow =  ImageLoader.loadImage("out/img/fleche_gauche.PNG");
        right_arrow = ImageLoader.loadImage("out/img/fleche_droit.PNG");
    }
}
