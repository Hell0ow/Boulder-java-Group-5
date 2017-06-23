package menu;

import state.MenuState;
import state.State;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class AppletMouse extends JPanel implements MouseListener, MouseMotionListener {


    private boolean leftPressed, rightPressed;
    private int mouseX;
    private int mouseY;


    //Getters
    public boolean isLeftPressed(){
        return leftPressed;
    }

    /**
     *
     * @return
     */
    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY(){
        return mouseY;
    }

    public AppletMouse(){

    }



    //implements
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

        this.mouseX = e.getX();
        this.mouseY = e.getY();

        if (State.getState() == Game.getMenuState()) {
            if (mouseX >= Display.getWidthframe() / 3 + 40 && mouseX <= Display.getWidthframe() / 3 + 340) {      //Game
                if (mouseY >= Display.getHeightframe() / 2 + 40 && mouseY <= Display.getHeightframe() / 2 + 90) {
                    State.setState(Game.getPreGameState());
                }
            }

            if (mouseX >= Display.getWidthframe() / 3 + 40 && mouseX <= Display.getWidthframe() / 3 + 340) {  //Settings
                if (mouseY >= Display.getHeightframe() / 2 + 150 && mouseY <= Display.getHeightframe() / 2 + 200) {
                    State.setState(Game.getSettingsState());
                }
            }
            if (mouseX >= Display.getWidthframe() / 3 + 40 && mouseX <= Display.getWidthframe() / 3 + 340) {  // Quit
                if (mouseY >= Display.getHeightframe() / 2 + 260 && mouseY <= Display.getHeightframe() / 2 + 310) {
                    System.exit(-1);
                }
            }
        }

        if (State.getState() == Game.getSettingsState()) {
            if (mouseX >= 80 && mouseX <= 230) {  // BACK settings
                if (mouseY >= Display.getHeightframe()-130 && mouseY <= Display.getHeightframe()-70) {
                    State.setState(Game.getMenuState());
                }
            }

            if (mouseX >= MenuState.playButton.x-300 && mouseX <= MenuState.playButton.x+170) {      //setSize1
                if (mouseY >= MenuState.playButton.y -250 && mouseY <= MenuState.playButton.y -200) {
                    Display.getFrame().setSize(1280, 960);
                    Display.setWidth(1280);
                    Display.setHeight(960);

                }
            }
            if (mouseX >= MenuState.playButton.x-300 && mouseX <= MenuState.playButton. x +170) {      //setSize2
                if (mouseY >= MenuState.playButton.y -150 && mouseY <= MenuState.playButton.y -100) {
                    Display.getFrame().setSize(1152, 832);
                    Display.setWidth(1152);
                    Display.setHeight(832);
                    System.out.println("mdrr");
                }
            }


            if(mouseX >= Display.getWidthframe() - 370 && mouseX <= Display.getWidthframe()-320) {
                if (mouseY >= Display.getHeightframe() - 110 && mouseY <= Display.getHeightframe() - 60) {
                    Sound.getGainControl().setValue((-80.0f));
                }
            }
            if(mouseX >= Display.getWidthframe() - 250 && mouseX <= Display.getWidthframe()-200) {
                if (mouseY >= Display.getHeightframe() - 110 && mouseY <= Display.getHeightframe() - 60) {
                    Sound.getGainControl().setValue((Sound.getGainControl().getValue()-6.0f));
                }
            }
            if(mouseX >= Display.getWidthframe() - 130 && mouseX <= Display.getWidthframe()-80) {
                if (mouseY >= Display.getHeightframe() - 110 && mouseY <= Display.getHeightframe() - 60) {
                    Sound.getGainControl().setValue((Sound.getGainControl().getValue()+6.0f));

                }
            }
            if(mouseX >= MenuState.playButton.x -150 && mouseX <= MenuState.playButton.x -10) {
                if (mouseY >= MenuState.playButton.y -10 && mouseY <= MenuState.playButton.y + 60) {
                    Game.setHideFpd(false);

                }
            }
            if(mouseX >= MenuState.playButton.x +30&& mouseX <= MenuState.playButton.x +170) {
                if (mouseY >= MenuState.playButton.y -10 && mouseY <= MenuState.playButton.y + 60) {
                    Game.setHideFpd(true);

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed =false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

}