package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EventGame implements KeyListener {
	
	public boolean UP, DOWN, LEFT, RIGHT;	
    private boolean[] keys, justPressed, cantPressed;

    public EventGame() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPressed = new boolean[keys.length];
    }

    public boolean keyJustPressed(int keyCode){
          if(keyCode < 0 || keyCode >= keys.length)
            return false;
          return justPressed[keyCode];
        }

    public void tick(){

        for(int i = 0; i < keys.length; i++){
            if(cantPressed[i] && !keys[i]){
                cantPressed[i] = false;
            }else if(justPressed[i]){
                cantPressed[i] = true;
                justPressed[i] = false;
            }
            if(!cantPressed[i] && keys[i]){
                justPressed[i] = true;
            }
        }

        UP = keys[KeyEvent.VK_Z];
        DOWN = keys[KeyEvent.VK_S];
        LEFT= keys[KeyEvent.VK_Q];
        RIGHT = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = false;

    }
}
