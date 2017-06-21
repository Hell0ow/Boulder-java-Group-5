package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Component extends JPanel {
	
	Entity entity;
	
	public Component(Entity entity) {
		super();
		
		this.entity = entity;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(entity.getElement().getSheet(), entity.getPosition().getX() * 64, entity.getPosition().getY()  * 64, 64, 64, null);
	}
}
