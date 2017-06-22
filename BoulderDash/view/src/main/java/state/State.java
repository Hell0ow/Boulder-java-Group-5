package state;

import java.awt.*;

/**
 * Created by Nicolas on 21/06/2017.
 */
public abstract class State {


    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    //CLASS

    public abstract  void tick();

    public abstract  void render(Graphics g);

}
