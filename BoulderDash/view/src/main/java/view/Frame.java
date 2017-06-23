package view;

import javax.swing.JFrame;

/**
 * JFrame class with a keyManager 
 * 
 * @author Pierre Hamel
 *
 */
public class Frame extends JFrame{
	
	/**
	 * Instantiate a new keyMaanger
	 */
	private KeyManager keyManager = new KeyManager();
	
	/**
	 * 
	 * @param title
	 */
	public Frame (String title){
		super(title);
		addKeyListener(keyManager);
	}
	
	/**
	 * Getter
	 * @return keyManager
	 */
	public KeyManager getKeyManager(){
		return keyManager;
	}
}
