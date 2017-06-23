package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class control the keyboard input
 * 
 * @author Pierre Hamel
 *
 */
public class KeyManager implements KeyListener{

	/**
	 * Key contains an action used in Order(model)
	 */
  private String key = new String();
  
  /**
   * Constructor
   */
  public KeyManager() {
  } 
  
  /**
   * Unused method from KeyListener
   */
  @Override
  public void keyTyped(KeyEvent e) {
  }

  /**
   * Send the keyboard input to the controller 
   */
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

  /**
   * reset key to NONE (do not move action)
   */
  @Override
  public void keyReleased(KeyEvent e) {
	  key = "NONE";
 }
  
  /**
   * Getter
   * @return key
   */
  public String getKey(){
	  return key;
  }
}