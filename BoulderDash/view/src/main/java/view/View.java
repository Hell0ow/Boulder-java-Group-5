package view;

import javax.swing.JFrame;
import Imodel.IBeing;
import Imodel.IEntity;
import Imodel.IModel;
import Iview.IView;

/**
 * View create the window which will display the game
 * 
 * @author Pierre Hamel
 *
 */
public class View implements IView {

	private Frame frame;
	//private IControllerKeyBoard controller;
	private IModel model;
	
	/**
	 * Defines the title of the window
	 */
	private String frameTitle = "Boulder Dash";
	
	/**
	 * Defines the width and height of the window
	 */
	private int frameWidth = 1200, frameHeight = 800;
	
	/**
	 * Constructor 
	 * Contains the window parameters
	 * @param model
	 */
	public View(IModel model/*, IControllerKeyBoard controller*/) {
		this.model = model;
		//this.controller = controller;
		
		frame = new Frame(frameTitle);
        frame.setSize(frameWidth,  frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	/**
	 * Remove all entities and then load entities and print them
	 */
	public void frame() throws Exception {
		
		frame.getContentPane().removeAll();
		
		for (IBeing being : model.getLevel().getTray().getBeings().values()) {
			printEntity((IEntity) being);
		}
		
		for (IEntity entity: model.getLevel().getTray().getTiles().values()) {
			printEntity(entity);
		}

		frame.repaint();
	}
	
	/**
	 * Add new entity to print it
	 */
	private void printEntity(IEntity entity) {
		frame.add(new Component(entity));
		frame.validate();
	}

	/**
	 * Getter for the window width
	 * @return frameWidth
	 */
	public int getFrameWidth() {
		return frameWidth;
	}
	
	/**
	 * Getter for the window height
	 * @returnframeHeight
	 */
	public int getFrameHeight() {
		return frameHeight;
	}
	
	/**
	 * @return frame
	 */
	public Frame getFrame(){
		return frame;
	}

}
