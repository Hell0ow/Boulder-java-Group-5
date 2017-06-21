package view;

import javax.swing.JFrame;

import model.Entity;
import model.Model;

public class View {

	private JFrame frame;
	private Model model;
	private String frameTitle = "TestVue";
	private int frameWidth = 1200, frameHeight = 800;
	
	public View(Model model) {
		this.model = model;
		
		frame = new JFrame(frameTitle);
        frame.setSize(frameWidth,  frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void frame() throws Exception {
		
		frame.getContentPane().removeAll();
		
		for (Entity entity : model.getLevel().getTray().getBeings().values()) {
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
}
