package state;

import java.awt.*;

/**
 * Created by Nicolas on 21/06/2017.
 */
public abstract class State {


    private static State currentState = null;
/**
     * Set state.
     *
     * @param state the state
     */
    public static void setState(State state){
        currentState = state;
    }
 /**
     * Get state state.
     *
     * @return the state
     */
    public static State getState(){
        return currentState;
    }

    //CLASS
/**
     * Tick.
     */
    public abstract  void tick();
/**
     * Render.
     *
     * @param g the g
     */
    public abstract  void render(Graphics g);

}
