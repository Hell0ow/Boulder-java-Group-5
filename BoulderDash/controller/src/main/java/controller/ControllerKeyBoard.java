package controller;

import model.Order;
import view.KeyManager;

public class ControllerKeyBoard{
	
	private static String key = new String();
	
	public static Order getOrder(KeyManager keyEvent) {
		
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





















