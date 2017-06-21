package controller;

import modelContract.IModel;
import view.IView;

public interface IController{
	
	public IModel getModel();
	
	public IView getView();
	
	public void initGame() throws Exception;
	
	public void newGame() throws Exception;
}
