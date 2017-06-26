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
		  key = "Z";
		  break;
	  case KeyEvent.VK_Q:
		  key = "Q";
		  break;
	  case KeyEvent.VK_D:
		  key = "D";
		  break;
	  case KeyEvent.VK_S:
		  key = "S";
		  break;
	  case KeyEvent.VK_UP:
		  key = "UP";
		  break;
	  case KeyEvent.VK_LEFT:
		  key = "LEFT";
		  break;
	  case KeyEvent.VK_RIGHT:
		  key = "RIGHT";
		  break;
	  case KeyEvent.VK_DOWN:
		  key = "DOWN";
		  break;
	  default:
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