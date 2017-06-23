package Icontroller;

import Imodel.IModel;
import Iview.IView;

public interface IController{
	
	public IModel getModel();
	
	public IView getView();
	
	public void initGame() throws Exception;
	
	public void Game() throws Exception;
}
