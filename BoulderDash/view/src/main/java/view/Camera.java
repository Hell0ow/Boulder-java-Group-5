package view;

import Imodel.IElement;
import Imodel.IModel;
import Iview.IView;

/**
 * Camera centered on the human and follows him on the map
 * 
 * @author Pierre Hamel
 *
 */
public class Camera {

	private IModel model;
	private IView view;
	/**
	 * Define the borders of the map
	 */
	private float xOffset, yOffset;
	
	/**
	 * Constructor
	 * @param model
	 * @param xOffset
	 * @param yOffset
	 */
	public Camera(IModel model, float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.model = model;
	}
	
	/**
	 * Check the blank space and stop just before display them
	 */
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > view.getFrameWidth() * 64 - view.getFrameWidth()){
			xOffset = view.getFrameWidth() * 64 - view.getFrameWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > view.getFrameHeight() * 64 - view.getFrameHeight()){
			yOffset = view.getFrameHeight() * 64 - view.getFrameHeight();
		}
		
	}
	
	/**
	 *  Center the camera on the human
	 * @param e
	 */
	public void centerOnEntity(IElement e){
		xOffset = model.getLevel().getTray().getHero().getPosition().getX() - view.getFrameWidth() / 2 + e.getWidth() / 2;
		yOffset = model.getLevel().getTray().getHero().getPosition().getY() - view.getFrameHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	/**
	 * Method used to move the camera
	 * @param xAmt
	 * @param yAmt
	 */
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	/**
	 * Getter
	 * @return xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * Setter
	 * @return xOffset
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * Getter
	 * @return yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * Setter
	 * @return yOffset
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
