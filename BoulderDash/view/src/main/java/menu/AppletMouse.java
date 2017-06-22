package menu;

import menu.Display;
import menu.Game;
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

    @Override
    public void mousePressed(MouseEvent e) {

        this.mouseX = e.getX();
        this.mouseY = e.getY();

        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;


        System.out.println("X: " + mouseX + "   Y: " + mouseY);

        if(mouseX >= Display.getWidthframe()/3+40 && mouseX <= Display.getWidthframe()/3+340){
            if (mouseY >= Display.getHeightframe()/2 + 40 && mouseY <= Display.getHeightframe()/2 + 90) {
                State.setState(Game.getPreGameState());
                System.out.println("TES DANS GAME");
            }
        }

        if(mouseX >= Display.getWidthframe()/3+40 && mouseX <= Display.getWidthframe()/3+340){
            if (mouseY >= Display.getHeightframe()/2 + 150 && mouseY <= Display.getHeightframe()/2 + 200) {
                State.setState(Game.getSettingsState());
                System.out.println("T'ES DANS LES SETTINGS");
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
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }

}
