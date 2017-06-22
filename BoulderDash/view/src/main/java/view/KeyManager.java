package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

  private boolean[] keys, justPressed, cantPressed;

  private String key = new String();
  
  public KeyManager() {
   keys = new boolean[256];
   justPressed = new boolean[keys.length];
   cantPressed = new boolean[keys.length];
  }
  
  
  
  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
	  switch (e.getKeyCode()){
	  case KeyEvent.VK_Z:
		  System.out.println("Z");
		  key = "Z";
		  break;
	  case KeyEvent.VK_Q:
		  System.out.println("Q");
		  key = "Q";
		  break;
	  case KeyEvent.VK_D:
		  System.out.println("D");
		  key = "D";
		  break;
	  case KeyEvent.VK_S:
		  System.out.println("S");
		  key = "S";
		  break;
	  case KeyEvent.VK_UP:
		  System.out.println("UP");
		  key = "UP";
		  break;
	  case KeyEvent.VK_LEFT:
		  System.out.println("LEFT");
		  key = "LEFT";
		  break;
	  case KeyEvent.VK_RIGHT:
		  System.out.println("RIGHT");
		  key = "RIGHT";
		  break;
	  case KeyEvent.VK_DOWN:
		  System.out.println("DOWN");
		  key = "DOWN";
		  break;
	  default:
		  System.out.println("NONE");
		  key = "NONE";
		  break;
	  }
  }

  @Override
  public void keyReleased(KeyEvent e) {
	  key = "NONE";
 }
  
  
  public String getKey(){
	  return key;
  }
}