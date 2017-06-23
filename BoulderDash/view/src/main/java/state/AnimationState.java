package state;
import gfx.Assets;
import menu.Display;
import menu.Game;

import java.awt.*;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class AnimationState extends State{

    
    private static int YAnimationTitle;
     /**
     * Instantiates a new Animation state.
     */
    
    public AnimationState(){
        YAnimationTitle = 0;
    }
     /**
     * Make the animation for the first Image when the game start
     */

    @Override
    public void tick(){
        AnimationState.setYAnimationTitle(AnimationState.getYAnimationTitle() + 5);

        if(YAnimationTitle > 800){
            State.setState(Game.getMenuState());
            //Game.checkState();
        }
    }
    /**
     * Display the Background and Title
     * @param g the g
     */

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.background, 0,0, Display.getWidthframe(), Display.getHeightframe(), null);
        g.drawImage(Assets.titleAnimation, 0,AnimationState.getYAnimationTitle(),Display.getWidthframe(), Display.getHeightframe(), null);

    }
/**
     * Gets the Y of animation title.
     *
     * @return the y animation title
     */

    public static int getYAnimationTitle() {
        return YAnimationTitle;
    }
    /**
     * Sets the Y of animation title.
     *
     * @param YAnimationTitle the y animation title
     */

    public static void setYAnimationTitle(int YAnimationTitle) {
        AnimationState.YAnimationTitle = YAnimationTitle;
    }
}
