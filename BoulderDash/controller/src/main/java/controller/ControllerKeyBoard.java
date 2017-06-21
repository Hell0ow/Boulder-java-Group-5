package controller;

import Icontroller.IControllerKeyBoard;
import Icontroller.IOrder;
import Imodel.IModel;
import model.Model;

public class ControllerKeyBoard implements IControllerKeyBoard{
	
	private IModel model;
	
	public ControllerKeyBoard(IModel model) throws Exception{
		this.model = model;
	}
	
	
	public static Model getKeyEvent(Order Eventkey){
		
		switch(Eventkey){
		
		case MOVE_UP:
			break;

		case MOVE_RIGHT:
			break;
			
		case MOVE_LEFT:
			break;
			
		case MOVE_DOWN:
			break;
			
		case DIG_UP:
			break;
			
		case DIG_RIGHT:
			break;
			
		case DIG_LEFT:
			break;
			
		case DIG_DOWN:
			break;
			
		case NONE:
			break;
		
		default:
			System.out.println("KEY ERROR : ControllerKeyBoard.getKeyEvent(Eventkey)");
			break;
			
		}
		return null;
	}


	@Override
	public IModel getKeyEvent(IOrder EventKey) {
		// TODO Auto-generated method stub
		return null;
	}
}





















