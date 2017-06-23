package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import Imodel.IEntity;

/**
 * Draw entities in the window
 * 
 * @author Pierre Hamel
 *
 */
public class Component extends JPanel {
	
	IEntity entity;
	
	/**
	 * Constructor
	 * @param entity
	 */
	public Component(IEntity entity) {
		super();
		
		this.entity = entity;
	}
	
	/**
	 * Method used to draw the entities with a specific with and height
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(entity.getElement().getSheet(), entity.getPosition().getX() * 64, entity.getPosition().getY()  * 64, 64, 64, null);
	}
}
