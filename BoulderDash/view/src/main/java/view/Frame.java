package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private KeyManager keyManager = new KeyManager();
	
	public Frame (String title){
		super(title);
		addKeyListener(keyManager);
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
}
