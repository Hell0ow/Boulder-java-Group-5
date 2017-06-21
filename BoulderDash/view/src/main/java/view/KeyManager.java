package view;

import java.awt.event.KeyEvent;
import Icontroller.*;
import java.awt.event.KeyListener;

import Icontroller.IControllerKeyBoard;
import Imodel.IModel;
import controller.ControllerKeyBoard;
import controller.Order;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	
	IControllerKeyBoard controller;
	
	public KeyManager(IModel model) {
		
		controller = new ControllerKeyBoard(model);
		keys = new boolean[256];
	}
		
	public ControllerKeyBoard getKeyPressed(){
		if(keys[KeyEvent.VK_Z])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.MOVE_UP);
		else if(keys[KeyEvent.VK_S])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.MOVE_DOWN);
		else if(keys[KeyEvent.VK_Q])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.MOVE_LEFT);
		else if(keys[KeyEvent.VK_D])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.MOVE_RIGHT);
		else if(keys[KeyEvent.VK_UP])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.DIG_UP);
		else if(keys[KeyEvent.VK_DOWN])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.DIG_DOWN);
		else if(keys[KeyEvent.VK_LEFT])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.DIG_LEFT);
		else if(keys[KeyEvent.VK_RIGHT])
			return (ControllerKeyBoard) controller.getKeyEvent(Order.DIG_RIGHT);
		else 
			return (ControllerKeyBoard) controller.getKeyEvent(Order.NONE);
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