package view;

import Imodel.IElement;
import Imodel.IModel;
import Iview.IView;

public class Camera {

	private IModel model;
	private IView view;
	private float xOffset, yOffset;
	
	public Camera(IModel model, float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.model = model;
	}
	
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
	
	public void centerOnEntity(IElement e){
		xOffset = model.getLevel().getTray().getHero().getPosition().getX() - view.getFrameWidth() / 2 + e.getWidth() / 2;
		yOffset = model.getLevel().getTray().getHero().getPosition().getY() - view.getFrameHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
