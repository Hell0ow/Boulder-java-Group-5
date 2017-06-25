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
    private Thread thread;


    public Sound(){

    }

    /**
     * Play the music and repeat it numberOfLoops times.
     */

    @Override
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("out/sound/Boulder_Dash_Theme.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0); // Reduce volume by 0 decibels.
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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

    /**
     * Create the new Thread for the music
     * @param delay
     * @param numberOfLoops
     */

    public synchronized void start(int delay, int numberOfLoops){
        thread = new Thread(this);
        thread.start();
    }


    /**
     * Gets gain control.
     *
     * @return the gain control
     */
    public static FloatControl getGainControl() {
        return gainControl;
    }/**
     * Sets clip.
     *
     * @param clip the clip
     */

    public static void setClip(Clip clip) {
        Sound.clip = clip;
    }
    /**
     * Gets clip.
     *
     * @return the clip
     */

    public static Clip getClip() {
        return clip;
    }
}
