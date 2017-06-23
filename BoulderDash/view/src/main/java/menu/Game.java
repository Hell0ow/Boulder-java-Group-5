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



    private static Display display;                        //The next next lines of variables are used to initialiaze the frame
    private int width, height;
    private String title;

    private boolean running = false;                // Used to run the game, if this variable is  false, the game stop
    private Thread thread;                          // Initialiaze the Thread

    private BufferStrategy bs;                      // Tools used to draw
    private Graphics g;

    private static int ticks;                       // Count the number of FPS
    private static int fpsNbr;                      // Variable which print the FPS number
    private static boolean hideFpd = false;         // Allow to Display/Hide the FPS number

     private static State animationState;           // The 5 next variables are used to initialize the different states of the game
     private static State menuState;
     private static State settingsState;
     private static State gamestate;
     private static State preGameState;


     private AppletMouse appletMouse;               // Tool used to detect the mouse, the program will now where you will click


    public Game(String title, int width, int height){   // Variables used to display the frame
        this.width = width;
        this.height = height;
        this.title = title;

        appletMouse = new AppletMouse();               //instantiate the mouse class
    }

    public void init() throws IOException {
        display = new Display(title, width, height);    // display the frame
        Assets.init();                                  // Load the different Images

        Display.getFrame().addMouseListener(appletMouse);         // Allow to use the methods in AppletMouse when an mouse event happens
        Display.getFrame().addMouseMotionListener(appletMouse);
        Display.getCanvas().addMouseListener(appletMouse);
        Display.getCanvas().addMouseMotionListener(appletMouse);


        animationState = new AnimationState();     // Instantiate the State class
        menuState = new MenuState();
        settingsState = new SettingsState();
        gamestate = new GameState();
        preGameState = new PreGamestate();

        State.setState(animationState);            // Initialize the first State

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
    public void tick(){
        if(State.getState() != null)
            State.getState().tick();
    }

    public void render(){
        bs = Display.getCanvas().getBufferStrategy();
        if(bs==null) {
            Display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0,0,width,height);


        // DRAW HERE
        if(State.getState() != null)
            State.getState().render(g);

        printFps(g);


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
                fpsNbr = ticks;
                ticks = 0;
                timer = 0;
            }

        }
        stop();
    }




    public static void printFps(Graphics g){
        if(!hideFpd) {
            g.setFont((new Font("TimesRoman", Font.PLAIN, 13)));
            g.setColor(Color.black);
            g.drawString("FPS: " + String.valueOf(Game.getFpsNbr()), 40, 40);
        }
    }


    public static void setHideFpd(boolean hideFpd) {
        Game.hideFpd = hideFpd;
    }

    public static int getFpsNbr() {
        return fpsNbr;
    }

    public AppletMouse getAppletMouse() {
        return appletMouse;
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