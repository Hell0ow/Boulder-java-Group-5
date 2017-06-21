package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.IControllerKeyBoard;
import model.IEntity;
import model.IModel;

public class ViewFacade implements IView {

	private JFrame frame;
	private IControllerKeyBoard controller;
	private IModel model;
	private String frameTitle = "TestVue";
	private int frameWidth = 1200, frameHeight = 800;
	
	public ViewFacade(IModel model, IControllerKeyBoard controller) {
		this.model = model;
		this.controller = controller;
		
		frame = new JFrame(frameTitle);
        frame.setSize(frameWidth,  frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void frame() throws Exception {
		
		frame.getContentPane().removeAll();
		
		for (IEntity entity : model.getLevel().getTray().getBeings().values()) {
			printEntity(entity);
		}
		
		for (Entity entity: model.getLevel().getTray().getTiles().values()) {
			printEntity(entity);
		}

		frame.repaint();
	}
	
	private void printEntity(Entity entity) {
		frame.add(new Component(entity));
		frame.validate();
	}
		
	 @Override
	    public final void displayMessage(final String message) {
	        JOptionPane.showMessageDialog(null, message);
	    }

}
