package menu;

import gfx.Assets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.*;

/**
 * Created by Nico on 22/06/2017.
 */
public class Sound implements Runnable{


    private static Clip clip;
    private static int token;
    private static FloatControl gainControl;
    private static int delay, numberOfLoops;

    public Sound(int delay, int numberOfLoops){
        this.delay = delay;
        this.numberOfLoops = numberOfLoops;
        Thread thread = new Thread(this);
        thread.start();
        music(delay, numberOfLoops);
    }



    public static void music(int delay, int numberOfLoops) {// arrete le programme, ou faut créer un Thread
        for (int i = 0; i < numberOfLoops; i++) {
            try {
                while(token < delay/500) {
                    token++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("D:/CESI année 1/Projet/Java/Sound/Boulder_Dash_Theme.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0); // Reduce volume by 0 decibels.
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static FloatControl getGainControl() {
        return gainControl;
    }

    public static void setClip(Clip clip) {
        sound.clip = clip;
    }


    public static Clip getClip() {
        return clip;
    }
}