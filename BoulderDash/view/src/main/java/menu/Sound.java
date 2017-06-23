package menu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.*;

/**
 * Created by Nico on 22/06/2017.
 */
public class Sound {


    private static Clip clip;
    private static int token;
    private static FloatControl gainControl;



    public static void music(String path, int delay, int numberOfLoops) {// arrete le programme, ou faut créer un Thread
        for (int i = 0; i < numberOfLoops; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File(path));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(0); // Reduce volume by 0 decibels.
                        clip.start();
                        //Thread.sleep(clip.getMicrosecondLength());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }.start();
            try {
                System.out.println(gainControl);
                while(token < delay/500) {
                    token++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static FloatControl getGainControl() {
        return gainControl;
    }

    public static void setClip(Clip clip) {
        Sound.clip = clip;
    }


    public static Clip getClip() {
        return clip;
    }
}
