package controller;

import model.Order;
import view.KeyManager;

/**
 * <b> ControllerKeyBoard have to manage key event from view.</p>
 * <p> The class receive the key event and launch an order </p>
 * 
 * @author Antoine Savalle
 * @version Hallah
 * @see Controller#Game()
 */
public class ControllerKeyBoard{
	
	/**
	 * <p>This String have to stock key event</p>
	 * @see ControllerKeyBoard#getOrder(KeyManager)
	 */
	protected static String key = new String();
	
	
	/**
	 * <p> This method just have to give an order in terms of key value. </p>
	 * @param keyEvent : KeyManager
	 * @return Order
	 * @see Controller#Game() -> }while(!model.cycle(ControllerKeyBoard.getOrder(keyEvent)));
	 */
	protected static Order getOrder(KeyManager keyEvent) {
		
		key = keyEvent.getKey();
		System.out.println(key);
        switch(key) {
            case "Z":
                return Order.MOVE_UP;
            case "D":
                return Order.MOVE_RIGHT;
            case "S":
                return Order.MOVE_DOWN;
            case "Q":
                return Order.MOVE_LEFT;
            case "UP":
                return Order.DIG_UP;
            case "RIGHT":
                return Order.DIG_RIGHT;
            case "DOWN":
                return Order.DIG_DOWN;
            case "LEFT":
                return Order.DIG_LEFT;
            default:
                return Order.NONE;
        }
        
    }
}





















