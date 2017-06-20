package controller;
import java.awt.event.KeyEvent;
import controller.MoveKey;
import java.awt.event.KeyListener;

public class ControllerKeyBoard extends ControllerFacade implements KeyListener{
	
	
	public ControllerKeyBoard() throws Exception{
		//this.addKeyListener(view);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/*
		switch(e.getKeyCode()){
		
		case KeyEvent.VK_Z:
			model.cycle(MoveKey.MOVE_UP);
			break;
		case KeyEvent.VK_Q:
			model.cycle(MoveKey.MOVE_LEFT);
			break;
		case KeyEvent.VK_D:
			model.cycle(MoveKey.MOVE_RIGHT);
			break;
		case KeyEvent.VK_S:
			model.cycle(MoveKey.MOVE_DOWN);
			break;
			
		case KeyEvent.VK_UP:
			model.cycle(MoveKey.DIG_UP);
			break;
		case KeyEvent.VK_LEFT:
			model.cycle(MoveKey.DIG_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			model.cycle(MoveKey.DIG_RIGHT);
			break;
		case KeyEvent.VK_DOWN:
			model.cycle(MoveKey.DIG_DOWN);
			break;
			
		}
		*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}






















