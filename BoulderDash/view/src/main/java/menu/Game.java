package menu;

import state.*;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Game implements  Runnable{



    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private static int ticks;

     private static State animationState;
     private static State menuState;
     private static State settingsState;
     private static State gamestate;
     private static State preGameState;

     private AppletMouse appletMouse;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        appletMouse = new AppletMouse();
    }

    public void init() throws IOException {
        display = new Display(title, width, height);
        Assets.init();

        Display.getFrame().addMouseListener(appletMouse);
        Display.getFrame().addMouseMotionListener(appletMouse);
        Display.getCanvas().addMouseListener(appletMouse);
        Display.getCanvas().addMouseMotionListener(appletMouse);


        animationState = new AnimationState();
        menuState = new MenuState();
        settingsState = new SettingsState();
        gamestate = new GameState();
        preGameState = new PreGamestate();

        State.setState(animationState);
    }

    public void tick(){
        if(State.getState() != null)
            State.getState().tick();
    }

    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs==null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0,0,width,height);




        // DRAW HERE
        if(State.getState() != null)
            State.getState().render(g);




        //END DRAWING
        bs.show();
        g.dispose();

    }

    public void run(){

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int fps = 60;  // Nombre d'image par seconde, nombr ede fois que les méthodes render et tick vont être appelées
        double timePerTick = 1000000000 / fps;  // temps qu'il y a entre chaque rafraichissement d'image / appel des méthodes
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();  // temps actuel en nano seconde
        long timer = 0;


        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;    // permet de savoir quand est-ce qu'on doir appeler les méthodes tick et render.
            timer += now - lastTime;
            lastTime = now;


            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer> 1000000000){
               // System.out.println("Images: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }
        stop();
    }

    public synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public AppletMouse getAppletMouse() {
        return appletMouse;
    }

    public static int getTicks(){
        return ticks;
    }

    public static State getMenuState() {
        return menuState;
    }

    public static State getAnimationState() {
        return animationState;
    }

    public static State getSettingsState() {
        return settingsState;
    }

    public static State getGamestate() {
        return gamestate;
    }

    public static State getPreGameState() {
        return preGameState;
    }
}
