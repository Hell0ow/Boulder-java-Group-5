package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IController;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	
	IController controler =  new Controller();
	
	public KeyManager() {
		keys = new boolean[256];
	}
		
	public void getKeyPressed(){
		if(keys[KeyEvent.VK_Z])
			return controller.getKeyEvent(MOVE_UP);
		else if(keys[KeyEvent.VK_S])
			return controller.getKeyEvent(MOVE_DOWN);
		else if(keys[KeyEvent.VK_Q])
			return controller.getKeyEvent(MOVE_LEFT);
		else if(keys[KeyEvent.VK_D])
			return controller.getKeyEvent(MOVE_RIGHT);
		else if(keys[KeyEvent.VK_UP])
			return controller.getKeyEvent(DIG_UP);
		else if(keys[KeyEvent.VK_DOWN])
			return controller.getKeyEvent(DIG_DOWN);
		else if(keys[KeyEvent.VK_LEFT])
			return controller.getKeyEvent(DIG_LEFT);
		else if(keys[KeyEvent.VK_RIGHT])
			return controller.getKeyEvent(DIG_RIGHT);
		else 
			return controller.getKeyEvent(NONE);
	}
		

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}